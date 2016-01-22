package pojo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the APPLICANT database table.
 * 
 */
@Entity
public class Applicant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="gen")    
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="login"))    
	private long appid;
	
	@Column(length=50)
	private String address;

	//private String appname;
	@Column(length=15)
	private String areaofinterest;

    @Temporal( TemporalType.DATE)
	private Date currentdate;

    @Column(length=50)
	private String currentlocation;

    @Temporal( TemporalType.DATE)
	private Date dateoperation;

    @Column(length=50)
	private String email;

    @Column(length=15)
	private String expertizelevel;

    @Column(length=30)
	private String fathersname;
    @Column(length=20)
	private String fname;

    @Column(length=6)
	private String gender;

    @Column(length=10)
	private String highestqualification;

    @Column(length=10)
	private String highschool;

    @Column(length=50)
	private String institute;

    @Column(length=10)
	private String intermediate;

    @Column(length=20)
	private String lname;

    @Column(length=20)
	private String mname;

    @Column(length=15)
	private String mobno;

	//private String password;

	//private String repassword;

	//private String securecode;

    @Column(length=30)
	private String skills;

    @Column(length=30)
	private String specialization;

    @Column(length=20)
	private String status;

    @Column(length=20)
	private boolean statusoflicense;

	//private String username;

    @Column(length=20)
	private String workexperience;

    @Column(length=20)
	private String yearofpassing;

	//bi-directional one-to-one association to Login
/*	@OneToOne
	@JoinColumn(name="APPID")*/
	@OneToOne
	@PrimaryKeyJoinColumn
	private Login login;

	//bi-directional many-to-one association to Applyvacancy
	@OneToMany(mappedBy="applicant")
	private List<Applyvacancy> applyvacancies;

    public Applicant() {
    }

	public long getAppid() {
		return this.appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getAreaofinterest() {
		return this.areaofinterest;
	}

	public void setAreaofinterest(String areaofinterest) {
		this.areaofinterest = areaofinterest;
	}

	public Date getCurrentdate() {
		return this.currentdate;
	}

	public void setCurrentdate(Date currentdate) {
		this.currentdate = currentdate;
	}

	public String getCurrentlocation() {
		return this.currentlocation;
	}

	public void setCurrentlocation(String currentlocation) {
		this.currentlocation = currentlocation;
	}

	public Date getDateoperation() {
		return this.dateoperation;
	}

	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpertizelevel() {
		return this.expertizelevel;
	}

	public void setExpertizelevel(String expertizelevel) {
		this.expertizelevel = expertizelevel;
	}

	public String getFathersname() {
		return this.fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHighestqualification() {
		return this.highestqualification;
	}

	public void setHighestqualification(String highestqualification) {
		this.highestqualification = highestqualification;
	}

	public String getHighschool() {
		return this.highschool;
	}

	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}

	public String getInstitute() {
		return this.institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getIntermediate() {
		return this.intermediate;
	}

	public void setIntermediate(String intermediate) {
		this.intermediate = intermediate;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMobno() {
		return this.mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getYearofpassing() {
		return this.yearofpassing;
	}

	public void setYearofpassing(String yearofpassing) {
		this.yearofpassing = yearofpassing;
	}

	public Login getLogin() {
		return this.login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	public List<Applyvacancy> getApplyvacancies() {
		return this.applyvacancies;
	}

	public void setApplyvacancies(List<Applyvacancy> applyvacancies) {
		this.applyvacancies = applyvacancies;
	}

	public boolean isStatusoflicense() {
		return statusoflicense;
	}

	public void setStatusoflicense(boolean statusoflicense) {
		this.statusoflicense = statusoflicense;
	}

	public String getWorkexperience() {
		return workexperience;
	}

	public void setWorkexperience(String workexperience) {
		this.workexperience = workexperience;
	}

	
}