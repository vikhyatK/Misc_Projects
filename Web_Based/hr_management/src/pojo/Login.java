package pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOGIN database table.
 * 
 */
@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userid;

	private String password;

	
	public Login(String password, String role, Employee employee) {
		super();
		this.password = password;
		this.role = role;
		this.employee = employee;
	}

	@Column(name="\"ROLE\"")
	private String role;

	//bi-directional one-to-one association to Applicant
	@OneToOne(mappedBy="login",cascade=CascadeType.ALL)
	private Applicant applicant;

	//bi-directional one-to-one association to Employee
	//@OneToOne(mappedBy="login")
	@OneToOne(mappedBy="login",cascade=CascadeType.ALL)
	private Employee employee;

    public Login() {
    }

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}