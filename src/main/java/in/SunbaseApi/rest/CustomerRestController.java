package in.SunbaseApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.SunbaseApi.request.CustomerReq;
import in.SunbaseApi.search.SearchCustomer;
import in.SunbaseApi.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

	@Autowired
	private CustomerService service;
	
//Create Customer (POST)
	@PostMapping(value="/savecustomer",
				consumes={"application/json"},
				produces= {"application/json"}
				)
	public ResponseEntity<CustomerReq> saveCustomer(@RequestBody CustomerReq reqest)
	{
		return new ResponseEntity<CustomerReq>(service.saveCustomer(reqest),HttpStatus.CREATED);
	}
	
//Get customerById
	@GetMapping(
				value="/findcustomer/{cid}",
				produces= "application/json"
				)
	public ResponseEntity<CustomerReq> getCustomerById(@PathVariable Integer cid)
	{
		return new ResponseEntity<CustomerReq>(service.getCustomer(cid),HttpStatus.CREATED);
	}
	
//SearchByFirstName,City,Email,PhoneNumber
	@PostMapping(
				value="/searchcustomer",
						consumes={"application/json"},
						produces= {"application/json"}
			)
	
	public List<CustomerReq> getCustomerByEntityValue(@RequestBody SearchCustomer request)
	{
		System.out.println(service.getSearchCust(request));
		return service.getSearchCust(request);
	}
//DeleteById
	@DeleteMapping(
			value="/deletecustomer/{cid}",
			produces= "application/json"
			)
	public ResponseEntity<Void> deleteCustomer(@PathVariable Integer cid)
	{
		System.out.println(cid);
		 service.deleteCustomer(cid);
		return ResponseEntity.noContent().build();
	}
//Update
	@PutMapping(
			value="/updatecustomer/{cid}",
					consumes={"application/json"},
					produces= {"application/json"}
		)
	public CustomerReq updateCustomerById(@PathVariable Integer cid,@RequestBody CustomerReq request)
	{	
		return service.updateCustomerEntity(cid, request);
	}
	
//Find All Record Pagination	
	@GetMapping(
			value="/allcustomer",
			produces= {"application/json"}
			)
    public ResponseEntity<List<CustomerReq>> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "cid,asc") String[] sort) {
        Pageable paging = PageRequest.of(page, size, Sort.by(Sort.Order.by(sort[0])));
        return new ResponseEntity<List<CustomerReq>>(service.getAllCustomers(paging),HttpStatus.OK);
    }
	
}
