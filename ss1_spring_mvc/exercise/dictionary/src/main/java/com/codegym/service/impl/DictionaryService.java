package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Override
    public Map<String, String> search() {
        Map<String,String> map = new LinkedHashMap<>();
        map.put("Blue","Xanh dương");
        map.put("Yellow","Vàng");
        map.put("Red","Đỏ");
        map.put("Green","Xanh lá");
        map.put("Black","Đen");
        map.put("White","Trắng");
        return map;
    }
}
