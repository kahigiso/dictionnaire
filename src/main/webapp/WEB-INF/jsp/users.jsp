<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 <table class="table table-hover table-bordered table-striped">
	 <thead>
		  <tr>
		    <th>First Name</th>
		    <th>Last Name</th>
		    <th>Email</th>
		    <th>Roles</th>
		    <th span="3">Action</th>
		  </tr>
	  </thead>
  <tbody>
	  <c:forEach items="${users}" var="user">
		  <tr>
		    <td><a href='<spring:url value="/user-details/${user.id}.html"/>'>${user.firstName}</a></td>
		    <td>${user.lastName}</td>
		    <td>${user.email}</td>
		     <td>${user.fullName()}</td>
		     <td>edit</td>
		     <td>delete</td>
		     <td>accivate</td>
		  </tr>
	   </c:forEach>
  </tbody>
</table>
