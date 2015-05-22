
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form:form action="userdo.htm" method="POST" commandName="bu">
            <table>
                    <tr>
                        <td>ID</td>
                        <td><form:input path="businessUnitId" /></td>
                    </tr>
                    <tr>
                        <td>First name</td>
                        <td><form:input path="businessUnit" /></td>
                    </tr>                    
                    <tr>
                        <td colspan="2">
                                <input type="submit" name="action" value="Add" />
                                <input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
                        </td>
                    </tr>
            </table>
        </form:form>
        
        <table border="1" cellpadding="10">
        <c:forEach items="${bus}" var="temp">
		<tr>			
                    <td>${temp.getBusinessUnit()}</td>
                    <td>${temp.getBusinessUnitId()}</td>
		</tr>
	</c:forEach>
        <table>
        
        
    </body>
</html>
