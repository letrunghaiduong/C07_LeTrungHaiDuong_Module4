package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            Integer currentValue = productMap.get(productDto);
            productMap.replace(productDto,currentValue +1);
        }else {
            productMap.put(productDto,1);
        }
    }
    public void clear(){
        productMap.clear();
    }
    public Double countTotalPayment() {
        Double total = 0.0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            total = total + entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
