package casestudy.repository.customer;

import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = " select *  from customer where name like %:name% and date_of_birth like %:dataOfBirth% and customer_type_id like %:CustomerTypeID% ", nativeQuery = true)
    Page<Customer> findPageSearchAll(Pageable pageable, @Param("name") String name, @Param("dataOfBirth") String dataOfBirth,@Param("CustomerTypeID") String CustomerTypeID);
}
