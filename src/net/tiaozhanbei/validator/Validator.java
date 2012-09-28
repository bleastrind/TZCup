package net.tiaozhanbei.validator;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.validator.FieldChecks;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.ValidatorAction;
import org.apache.struts.action.ActionMessages;
import org.apache.strutsel.taglib.utils.EvalHelper;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.util.ValidatorUtils;
public class Validator implements Serializable {

	public Validator() {
		// TODO Auto-generated constructor stub
	}
	private void ValidatorUser(Object bean,ValidatorAction va,
			Field field,ActionMessages errors,Validator validator,HttpServletRequest request){
		String email;
		System.out.println("执行了自定义的验证方法！");
		
		
		
		
	}

}
