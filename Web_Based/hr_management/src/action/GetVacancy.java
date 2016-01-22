package action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.VacancyDao;
import pojo.Vacancy;

public class GetVacancy extends ActionSupport implements  ServletRequestAware,SessionAware{

	private int vid;
	private VacancyDao dao;
	Vacancy vaca=null;
	HttpServletRequest request;
	private Map map;
	@Override
	public String execute() throws Exception {
		dao=new VacancyDao();
		vaca=dao.viewVacancyDetail(vid);
		request.setAttribute("vaca", vaca);
		map.put("vac", vaca);
		map.put("vid", vaca.getVid());
		return SUCCESS;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request=arg0;
		
	}
	public Vacancy getVaca() {
		return vaca;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		map=arg0;
		
	}
	
	
}
