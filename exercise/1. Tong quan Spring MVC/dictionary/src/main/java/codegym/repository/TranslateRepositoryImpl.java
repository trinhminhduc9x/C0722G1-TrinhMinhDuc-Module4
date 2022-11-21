package codegym.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateRepositoryImpl implements TranslateRepository {
    private static Map<String, String> dictionaryStock = new HashMap<>();

    static {
        dictionaryStock.put("name", "tên");
        dictionaryStock.put("age", "tuổi");
        dictionaryStock.put("love", "yêu");
        dictionaryStock.put("hate", "ghét");
        dictionaryStock.put("horror", "ghê");
        dictionaryStock.put("sad", "buồn");
    }

    @Override
    public String translate(String eng) {
        if (dictionaryStock.get(eng.toLowerCase()) == null) {
            return "Not found!";
        }
        return dictionaryStock.get(eng.toLowerCase());
    }
}