package in.ashokit.__Customer_API.repository;

import in.ashokit.__Customer_API.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Integer> {

}
