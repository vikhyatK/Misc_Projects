package action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import pojo.Vacancy;

import com.opensymphony.xwork2.ActionSupport;

import dao.ApplyVacancyDao;
import dao.VacancyDao;

public class FetchToAppVacancy extends ActionSupport implements ServletRequestAware
{
	HttpServletRequest request;
	//ApplyVacancyDao dao=new ApplyVacancyDao();
	VacancyDao dao =new VacancyDao();
	String vac;
	//HashMap<Long, String> hm;
	

	@Override
	public String execute() throws Exception 
	{
		/*String applicantid=dao.fetchappid(-1,"in process");
		request.setAttribute("applicantid", applicantid);
		*/
		/*String vacancyid=dao.fetchvid(-1);
		request.setAttribute("vacancyid",vacancyid);
		
		
		String Hrid=dao.fetchHrempid(-1,"hr");
		request.setAttribute("hrid",Hrid);
		
		String Irid=dao.fetchIrempid(-1,"iw");
		request.setAttribute("irid",Irid);
		*/
	//hm=dao.getAllVacancy();
		//request.setAttribute("vaca", hm);
		//System.out.println("map "+hm);
		
		vac=dao.getAllVacancies();
		request.setAttribute("vaca", vac);
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0)
	{
	
		this.request=arg0;
	}

}
