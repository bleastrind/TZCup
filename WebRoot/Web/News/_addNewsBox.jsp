<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form name="addNews" method="post" action="">
	<table>
		<tbody>
			<td>
				<tr>
					新闻标题：
					<input type="text" name="tile">
				</tr>
				<tr>
					新闻内容：
				
					<script type="text/javascript">
					
<!--
// Automatically calculates the editor base path based on the _samples directory.
// This is usefull only for these samples. A real application should use something like this:
// oFCKeditor.BasePath = '/fckeditor/' ;	// '/fckeditor/' is the default value.
var sBasePath = document.location.href.substring(0,document.location.href.lastIndexOf('_samples')) ;

var oFCKeditor = new FCKeditor( 'FCKeditor1' ) ;
oFCKeditor.BasePath	= sBasePath ;
oFCKeditor.Height	= 300 ;
oFCKeditor.Value	= '' ;
oFCKeditor.Create() ;
//-->
				</script>
				</tr>
				
			
		</tbody>
	</table>
</form>
