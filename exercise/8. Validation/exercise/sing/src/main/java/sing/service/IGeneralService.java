package sing.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    void save(T t);

    void remove(Integer id);

    void update(T t);

    List<T> findAll();




}