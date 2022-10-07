<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/26/2022
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Setting</h1>
  <h2>${mess}</h2>
  <form:form action="" method="post" modelAttribute="medical">
      <pre>Languages:       <form:select path="language">
                                <form:option value="English">English</form:option>
                                <form:option value="Vietnamese">Vietnamese</form:option>
                                <form:option value="Japanese">Japanese</form:option>
                                <form:option value="Chinese">Chinese</form:option>
                            </form:select>
      </pre>
      <pre>Page size:       Show <form:select path="pageSize">
                                <form:option value="5">5</form:option>
                                <form:option value="10">10</form:option>
                                <form:option value="15">15</form:option>
                                <form:option value="25">25</form:option>
                                <form:option value="50">50</form:option>
                                <form:option value="100">100</form:option>
                            </form:select> emails per page.</pre>
      <pre>Spams filter:    <form:checkbox path="spamFilter" value="spam"/>Enable spam filter.</pre>
      <pre>Signature:       <form:input path="signature" type="text"/></pre>
      <pre>     <button type="submit">Update</button>   <button>cancel</button></pre>
  </form:form>
  </body>
</html>
