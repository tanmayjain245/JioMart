package com.jiomart.shop.services;

import com.jiomart.shop.entity.OrderDetails;
import com.jiomart.shop.entity.Product;
import com.jiomart.shop.vo.OrderDetailsVo;

public class OrderDetailsService {
    public static OrderDetails convertToOrderDetail(OrderDetailsVo orderDetailsVo) {
        OrderDetails orderDetail = new OrderDetails();
        Product product = new Product();
        product.setProductID(orderDetailsVo.getProductID());
        orderDetail.setProduct(product);
        orderDetail.setQuantity(orderDetailsVo.getQuantity());
        return orderDetail;
    }
}
