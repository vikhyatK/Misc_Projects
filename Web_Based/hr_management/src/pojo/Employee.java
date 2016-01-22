package pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="gen")    
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="login"))    
	private long empid;

	private String address;

	private String bloodgroup;

	private BigDecimal deptid;

	private String email;

	private BigDecimal emob;

	private String fname;

    @Temporal( TemporalType.DATE)
	private Date joiningdate;

	private String lname;

	private String location;

	private String mname;

	private String passport;

	//bi-directional many-to-one association to Applyvacancy
	@OneToMany(mappedBy="employee1")
	private List<Applyvacancy> applyvacancies1;

	//bi-directional many-to-one association to Applyvacancy
	@OneToMany(mappedBy="employee2")
	private List<Applyvacancy> applyvacancies2;

	//bi-directional one-to-one association to Login
	@OneToOne
	//@JoinColumn(name="EMPID")
	@PrimaryKeyJoinColumn
	private Login login;

	public Employee(long empid) {
		super();
		this.empid = empid;
	}

	//bi-directional many-to-one association to Vacancy
	@OneToMany(mappedBy="employee")
	private List<Vacancy> vacancies;

    public Employee() {
    }

	public long getEmpid() {
		return this.empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodgroup() {
		return this.bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public BigDecimal getDeptid() {
		return this.deptid;
	}

	public void setDeptid(BigDecimal deptid) {
		this.deptid = deptid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getEmob() {
		return this.emob;
	}

	public void setEmob(BigDecimal emob) {
		this.emob = emob;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Date getJoiningdate() {
		return this.joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	
	public List<Applyvacancy> getApplyvacancies1() {
		return this.applyvacancies1;
	}

	public void setApplyvacancies1(List<Applyvacancy> applyvacancies1) {
		this.applyvacancies1 = applyvacancies1;
	}
	
	public List<Applyvacancy> getApplyvacancies2() {
		return this.applyvacancies2;
	}

	public void setApplyvacancies2(List<Applyvacancy> applyvacancies2) {
		this.applyvacancies2 = applyvacancies2;
	}
	
	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public List<Vacancy> getVacancies() {
		return this.vacancies;
	}

	public void setVacancies(List<Vacancy> vacancies) {
		this.vacancies = vacancies;
	}

}