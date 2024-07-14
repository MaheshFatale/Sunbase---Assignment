package in.SunbaseApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.SunbaseApi.repository.CustomerRepository;
import in.SunbaseApi.request.CustomerReq;
import in.SunbaseApi.search.SearchCustomer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository repos; 
	
//SaveCustomer
	@Override
	public CustomerReq saveCustomer(CustomerReq req) {
		CustomerReq res=new CustomerReq();
		BeanUtils.copyProperties(req, res);
		CustomerReq rs=repos.save(res);
		return rs;
	}
//findById
	@Override
	public CustomerReq getCustomer(Integer cid) {
		if(repos.existsById(cid))
			return repos.findById(cid).get();
		return null;
	}
	
//SearchListOf CustomerByfirstname,city,email,phoneno
	@Override
	public List<CustomerReq> getSearchCust(SearchCustomer searcust) {
		CustomerReq c1=new CustomerReq();
		if(!searcust.getFirst_Name().isEmpty() && !"".equals(searcust.getFirst_Name()))
		c1.setFirst_Name(searcust.getFirst_Name());
		
		if(!searcust.getCity().isEmpty() && !"".equals(searcust.getCity()))
		c1.setCity(searcust.getCity());
		
		if(!searcust.getEmail().isEmpty() && !"".equals(searcust.getEmail()))
		c1.setEmail(searcust.getEmail());
		
		if(!searcust.getPhoneNo().isEmpty() && !"".equals(searcust.getPhoneNo()))
		c1.setPhoneNo(searcust.getPhoneNo());
		
		return repos.findAll(Example.of(c1));
	}
	
//deletebyId
	@Override
	public void deleteCustomer(Integer cid) {
		CustomerReq resp=repos.findById(cid).get();
			repos.delete(resp);	
	}
	
////Update Customer	
	@Override
	public CustomerReq updateCustomerEntity(Integer cid, CustomerReq cust) {		
		CustomerReq c1=repos.findById(cid).get();
		BeanUtils.copyProperties(cust, c1);
		repos.save(c1);
		return c1;
	}
	
	//Find All Record Pagination	
	 public List<CustomerReq> getAllCustomers(Pageable pageable) {
	        return repos.findAll(pageable).getContent();
	    }
	/**
	@Autowired
	private CustomerRepository repo;
	
//	public List<CustomerEntity> getCustomer(int pageno) {
//		//int pageno=2;
//		PageRequest p1=PageRequest.of(pageno-1, 10);
//		org.springframework.data.domain.Page<CustomerEntity> custmerlist=repo.findAll(p1);
//		List<CustomerEntity> listcust=custmerlist.getContent();
//		
//		return listcust;
//	}

	@Override
	public List<CustomerEntity> getAllCustomerEntity(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

*/
}
