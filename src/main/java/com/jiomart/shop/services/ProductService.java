package com.jiomart.shop.services;

import com.jiomart.shop.entity.Product;
import com.jiomart.shop.entity.Supplier;
import com.jiomart.shop.exceptions.ProductAlreadyExistException;
import com.jiomart.shop.exceptions.ProductNotFoundException;
import com.jiomart.shop.exceptions.SupplierNotFoundException;
import com.jiomart.shop.repository.ProductRepository;
import com.jiomart.shop.repository.SupplierRepository;
import com.jiomart.shop.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.validation.ConstraintViolationException;
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
    public ResponseEntity<Product> getProductByPid(Integer pid) throws ProductNotFoundException {
        return new ResponseEntity<>(productRepository.findById(pid).orElseThrow(() -> new ProductNotFoundException(pid)), HttpStatus.OK);
    }

    @Transactional(readOnly=false,propagation= Propagation.REQUIRED)
    public void saveProduct(List<ProductVo> products) throws ProductAlreadyExistException, SupplierNotFoundException, ConstraintViolationException {
        for (ProductVo product : products) {
            if (productRepository.findById(product.getProductID()).isPresent()) {
                throw new ProductAlreadyExistException(product.getProductID());
            }
            productRepository.save(getEntity(product));
        }
    }
    public void updateProduct(List<ProductVo> products) throws ProductNotFoundException, SupplierNotFoundException,ConstraintViolationException {
        for (ProductVo p : products) {
            if (productRepository.findById(p.getProductID()).isEmpty()) {
                throw new ProductNotFoundException(p.getProductID());
            }
            productRepository.save(getEntity(p));
        }
    }

    public Product getEntity(ProductVo product) throws SupplierNotFoundException {
        Product p1=new Product();
        p1.setProductID(product.getProductID());
        p1.setPrice(product.getPrice());
        p1.setProductName(product.getProductName());
        p1.setUnit(product.getUnit());
        Optional<Supplier> supplier=supplierRepository.findById(product.getSupplierID());
        if (supplier.isEmpty()){
            throw new SupplierNotFoundException(product.getSupplierID());
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
