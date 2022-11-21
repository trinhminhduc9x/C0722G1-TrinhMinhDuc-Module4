package codegym.service;

import codegym.repository.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TranslateServiceImpl implements codegym.service.TranslateService {
    @Autowired
    private TranslateRepository translateRepository;

    @Override
    public String translate(String eng) {
        return this.translateRepository.translate(eng);
    }
}


