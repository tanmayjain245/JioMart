package com.jiomart.shop.services;

import com.jiomart.shop.entity.Product;
import com.jiomart.shop.entity.Supplier;
import com.jiomart.shop.exception.ProductException;
import com.jiomart.shop.exception.SupplierException;
import com.jiomart.shop.repository.ProductRepository;
import com.jiomart.shop.repository.SupplierRepository;
import com.jiomart.shop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Product> getProductByPid(Integer pid) {
        return new ResponseEntity<>(productRepository.findById(pid).orElseThrow(() -> new ProductException("product not found with id: "+pid)), HttpStatus.OK);
    }

    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void saveProduct(List<ProductVo> products)  {
        for (ProductVo product : products) {
            if (productRepository.findById(product.getProductID()).isPresent()) {
                throw new ProductException("Product already exist with id: "+product.getProductID());
            }
            productRepository.save(getEntity(product));
        }
    }
    public void updateProduct(List<ProductVo> products) {
        for (ProductVo p : products) {
            if (productRepository.findById(p.getProductID()).isEmpty()) {
                throw new ProductException("Product  not found with id: "+ p.getProductID());
            }
            productRepository.save(getEntity(p));
        }
    }
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Deleted product with id : " + id;
    }

    public Product getEntity(ProductVo product) {
        Product p1=new Product();
        p1.setProductID(product.getProductID());
        p1.setPrice(product.getPrice());
        p1.setProductName(product.getProductName());
        p1.setUnit(product.getUnit());
        p1.setProductImg(product.getProductImg());
        Optional<Supplier> supplier=supplierRepository.findById(product.getSupplierID());
        if (supplier.isEmpty()){
            throw new SupplierException("Supplier not found with id: "+product.getSupplierID());
        }
        p1.setSupplier(supplier.get());
        return p1;


//        private static Products convertToProduct(ProductVo productVo) {
//            Products product = new Products();
//            product.setProductName(productVo.getProductName());
//            product.setUnit(productVo.getUnit());
//            product.setPrice(productVo.getPrice());
//            Suppliers supplier = new Suppliers();
//            supplier.setSupplierId(productVo.getSupplierId());
//            product.setSupplier(supplier);
//
//            return product;
//        }


     //   p1.setSupplier(product.getSupplierID());
//        return Product.builder()
//                .productName(product.getProductName())
//                .productID(product.getProductID())
//                .price(product.getPrice())
//                .supplier(supplierRepository.findById(product.getSupplierID()).orElseThrow(()-> new SupplierNotFoundException(product.getSupplierID())))
//                .unit(product.getUnit()).build();
    }


}
