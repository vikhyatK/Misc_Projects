package action;
import pojo.Applicant;
import pojo.Applyvacancy;
import pojo.Vacancy;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ApplicantDao;
import dao.ApplyVacancyDao;

public class ApplyVacancyAction extends ActionSupport implements SessionAware{

	int vid;
	//private List<Applyvacancy> app=new ArrayList<>();
	private ApplyVacancyDao avd;
	Map<String,Object> map;
	@Override
	public String execute() throws Exception {
		GregorianCalendar gc=new GregorianCalendar();
		avd=new ApplyVacancyDao();
		
		/*ApplyvacancyPK apvid=new ApplyvacancyPK();
		apvid.setAppid(Long.parseLong((String) map.get("eid")));
		apvid.setVid(vid);
		Applyvacancy apply=new Applyvacancy();
		apply.setId(apvid);*/
		
		Applyvacancy apply=new Applyvacancy();
		Vacancy v=new Vacancy();
		v.setVid(vid);
		apply.setVacancy(v);
		
		Applicant applicant=new Applicant();
		applicant.setAppid(Long.parseLong((String) map.get("eid")));
		apply.setApplicant(applicant);
		apply.setApplydate(gc.getTime());
		//app.add(apply);
		
		//v.setApplyvacancies(app);
		avd.create(apply);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		map=arg0;
		
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	
}
