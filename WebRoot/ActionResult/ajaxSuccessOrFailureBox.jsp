<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%><%String messagekey = (String)request.getAttribute("messagekey");%><%=request.getAttribute("message")%><%if(messagekey!=null) {%><bean:message key="<%=messagekey %>"/><%}%>