package demo.demo.repository;

import demo.demo.model.Customer;
import demo.demo.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Integer> {

}
