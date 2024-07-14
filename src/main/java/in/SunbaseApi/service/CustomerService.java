package in.SunbaseApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import in.SunbaseApi.request.CustomerReq;
import in.SunbaseApi.search.SearchCustomer;

public interface CustomerService {
	
	
//Save Customer
	public CustomerReq saveCustomer(CustomerReq req);
	
//Get CustomerById
	public CustomerReq getCustomer(Integer cid);

//Get CustomerBy first_name,city,email,phoneNo
	public List<CustomerReq> getSearchCust(SearchCustomer searcust);

//delete CustomerById
	public void deleteCustomer(Integer cid);	

//Update CustomerById
	public CustomerReq updateCustomerEntity(Integer cid,CustomerReq cust);
	
//Find All Record Pagination
	 public List<CustomerReq> getAllCustomers(Pageable pageable);
	/**
//	public List<CustomerEntity> getCustomer(int pageno);

//	public List<CustomerEntity> getAllCustomerEntity(Pageable pageable);	
*/
}
