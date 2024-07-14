package in.SunbaseApi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import in.SunbaseApi.request.CustomerReq;
@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<CustomerReq, Integer>{



}
