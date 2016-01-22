 package pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the APPLYVACANCY database table.
 * 
 */
@Entity
public class Applyvacancy implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long apvacancyid;

    @Temporal( TemporalType.DATE)
	private Date applydate;

    @Temporal( TemporalType.DATE)
	private Date scheduledate;

	//bi-directional many-to-one association to Applicant
    @ManyToOne
	@JoinColumn(name="APPID")
	private Applicant applicant;

	//bi-directional many-to-one association to Employee
    @ManyToOne
	@JoinColumn(name="IRID")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
    @ManyToOne
	@JoinColumn(name="HRID")
	private Employee employee2;

	//bi-directional many-to-one association to Vacancy
    @ManyToOne
	@JoinColumn(name="VID")
	private Vacancy vacancy;

    public Applyvacancy() {
    }

	public long getApvacancyid() {
		return this.apvacancyid;
	}

	public void setApvacancyid(long apvacancyid) {
		this.apvacancyid = apvacancyid;
	}

	public Date getApplydate() {
		return this.applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public Date getScheduledate() {
		return this.scheduledate;
	}

	public void setScheduledate(Date scheduledate) {
		this.scheduledate = scheduledate;
	}

	public Applicant getApplicant() {
		return this.applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	
	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}
	
	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}
	
	public Vacancy getVacancy() {
		return this.vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public String toString() {
		return "Applyvacancy [ vacancy=" + vacancy + "]";
	}
	
	
	
}