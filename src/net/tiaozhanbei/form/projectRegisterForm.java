package net.tiaozhanbei.form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class projectRegisterForm extends ActionForm{

	
		/**
	 * 
	 */
	private static final long serialVersionUID = 3822589937313574092L;
		private String name;
	    private String type;
	    private String brief;
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
