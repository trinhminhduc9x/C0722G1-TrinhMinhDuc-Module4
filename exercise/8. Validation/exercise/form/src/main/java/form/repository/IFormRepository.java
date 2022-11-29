package form.repository;

import form.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFormRepository extends JpaRepository<Form,Integer> {
}
