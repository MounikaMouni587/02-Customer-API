package in.ashokit.__Customer_API.repository;

import in.ashokit.__Customer_API.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress,Integer> {

    //select *from shipping address were customer id=?
    public List<ShippingAddress> findByCustomerCustomerIdAndDeleteSw(Integer customerId,String deleteSw);

}
