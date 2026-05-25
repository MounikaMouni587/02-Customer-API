package in.ashokit.__Customer_API.repository;

import in.ashokit.__Customer_API.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
