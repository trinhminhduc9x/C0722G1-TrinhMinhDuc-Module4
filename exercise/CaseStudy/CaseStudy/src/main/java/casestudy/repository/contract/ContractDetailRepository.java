package casestudy.repository.contract;

import casestudy.model.contract.ContractDetail;
import casestudy.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Query(value = " select *  from contract_detail where contract_id like %:contractId%   ", nativeQuery = true)
    List<ContractDetail> findListContracDetailByIdContract(@Param("contractId") Integer contractId);


}
