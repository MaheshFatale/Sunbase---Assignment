package in.SunbaseApi.request;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class CustomerReq {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String first_Name;
	private String last_Name;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phoneNo;

}
