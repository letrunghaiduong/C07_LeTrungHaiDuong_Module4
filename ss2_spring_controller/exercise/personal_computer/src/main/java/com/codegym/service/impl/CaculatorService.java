package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Override
    public double caculator(String calculation,int number1,int number2) {
        double result = 0;
        switch (calculation){
            case "Addition(+)":
                result = number1 + number2;
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                break;
            case "Multiplication(*)":
                result = number1 * number2;
                break;
            case "Division(/)":
                if (number1 == 0 || number2 == 0){
                    result = 0;
                }else {
                    result = number1 / number2;
                }
                break;
        }
        return result;
    }
}
