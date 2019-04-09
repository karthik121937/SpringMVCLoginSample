<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">
 
  <a href="${pageContext.request.contextPath}/welcome">Home</a>
 
  | &nbsp;
  
   <a href="${pageContext.request.contextPath}/userInfo">User Info</a>
  
  | &nbsp;
  
  <a href="${pageContext.request.contextPath}/admin">Admin</a>

  
  <c:choose>
    <c:when test="${pageContext.request.userPrincipal.name != null}">
        | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a> 
    </c:when>    
    <c:otherwise>
    | &nbsp;
        <a href="${pageContext.request.contextPath}/login">Login</a>
        
    </c:otherwise>
</c:choose>
  
  
  
  
  
</div>