package net.tiaozhanbei.form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class regAuthorAndProjectForm  extends ActionForm {
		/**
	 * 
	 */
	private static final long serialVersionUID = -478122612438747640L;
		/**
	 * 
	 */
	
		private String realName;
	    private String phone;
	    private String department;

	    private String name;
	    private String type;
	    private String brief;
	    
		
		
		public String getRealName() {
			return realName;
		}
		public void setRealName(String realName) {
			this.realName = realName;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		
	  
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getBrief() {
			return brief;
		}
		public void setBrief(String brief) {
			this.brief = brief;
		}
		public ActionErrors validate(ActionMapping mapping,
				HttpServletRequest request) {
			// TODO Auto-generated method stub
			return null;
		}
	
	
	
	

}
