package form.service;

import form.model.Form;

import java.util.Optional;

public interface IFormService extends IGeneralService<Form> {
    @Override
    Iterable<Form> findAll();

    @Override
    Optional<Form> findById(Long id);

    @Override
    void save(Form form);

    @Override
    void remove(Long id);
}
