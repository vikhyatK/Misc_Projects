package pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * The persistent class for the VACANCY database table.
 * 
 */
@Entity
public class Vacancy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long vid;

    @Temporal( TemporalType.DATE)
	private Date closingdate;

	private BigDecimal deptid;

	private String description;

	private BigDecimal jobopenings;

    @Temporal( TemporalType.DATE)
	private Date openingdate;

	private String ownedby;

	private String status;

	private String title;

	//bi-directional many-to-one association to Applyvacancy
	@OneToMany(mappedBy="vacancy")
	private List<Applyvacancy> applyvacancies;

	//bi-directional many-to-one association to Employee
    @ManyToOne
	@JoinColumn(name="EMPID")
	private Employee employee;

    public Vacancy() {
    }

	public long getVid() {
		return this.vid;
	}

	public void setVid(long vid) {
		this.vid = vid;
	}

	
	public Date getClosingdate() {
		return this.closingdate;
	}

	
	public void setClosingdate(Date closingdate) {
		this.closingdate = closingdate;
	}

	public BigDecimal getDeptid() {
		return this.deptid;
	}

	
	public void setDeptid(BigDecimal deptid) {
		this.deptid = deptid;
	}

	
	public String getDescription() {
		return this.description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getJobopenings() {
		return this.jobopenings;
	}

	
	public void setJobopenings(BigDecimal jobopenings) {
		this.jobopenings = jobopenings;
	}

	public Date getOpeningdate() {
		return this.openingdate;
	}

	public void setOpeningdate(Date openingdate) {
		this.openingdate = openingdate;
	}

	public String getOwnedby() {
		return this.ownedby;
	}

	public void setOwnedby(String ownedby) {
		this.ownedby = ownedby;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Applyvacancy> getApplyvacancies() {
		return this.applyvacancies;
	}

	public void setApplyvacancies(List<Applyvacancy> applyvacancies) {
		this.applyvacancies = applyvacancies;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}