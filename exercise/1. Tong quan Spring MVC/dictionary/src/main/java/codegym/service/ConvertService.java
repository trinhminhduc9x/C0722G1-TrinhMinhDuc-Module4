package codegym.service;


import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService{
    @Override
    public double convert(double rate, double usd) {
        return usd*rate;
    }
}
