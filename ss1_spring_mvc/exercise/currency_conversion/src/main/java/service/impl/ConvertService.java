package service.impl;

import org.springframework.stereotype.Service;
import service.IConvertService;
@Service
public class ConvertService implements IConvertService {

    @Override
    public double convert(double usd) {
        return usd * 21000;
    }
}
