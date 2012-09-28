package net.tiaozhanbei.form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
public class passWordForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5740001938307148448L;
	private String newpassword;
	private String oldpassword;
	public String getPassword() {
		return newpassword;
	}
	public void setPassword(String password) {
		this.newpassword = password;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
