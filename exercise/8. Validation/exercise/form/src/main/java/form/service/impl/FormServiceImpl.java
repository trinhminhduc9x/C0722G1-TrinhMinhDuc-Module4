package form.service.impl;

import form.model.Form;
import form.repository.IFormRepository;
import form.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class FormServiceImpl implements IFormService {

    @Autowired
    private IFormRepository repository;

    @Override
    public Iterable<Form> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Form> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Form form) {
        repository.save(form);
    }

    @Override
    public void remove(Long id) {

    }
}
