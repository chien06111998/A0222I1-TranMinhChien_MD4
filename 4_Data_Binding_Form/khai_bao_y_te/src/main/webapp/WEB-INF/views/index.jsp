<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/26/2022
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <center>
        <h1>TO KHAI Y TE</h1>
        <h2>DAY LA TAI LIEU QUAN TRONG, THONG TIN CUA ANH/CHI SE GIUP CO QUAN Y TE LIEN LAC KHI CAN THIET DE PHONG CHONG DICH BENH TRUYEN NHIEM</h2>
        <h3>Khuyen cao: Khai bao thong tin sai la vi pham phap luat Viet Nam va co the xu ly hinh su</h3>
    </center>
    <form:form action="" method="post" modelAttribute="healthDeclaration">
        <table>
            <tr>
                <th>Name(Floral print)</th>
                <td><form:input path="name"></form:input></td>
            </tr>
            <tr>
                <td>
                    <td>
                        <th>Birth Day</th>
                        <td><form:input path="birthDay"></form:input></td>
                    </td>
                    <td>
                        <th>Gender</th>
                        <td><form:input path="gender"></form:input></td>
                    </td>
                    <td>
                        <th>Nationality</th>
                        <td><form:input path="nationality"></form:input></td>
                    </td>
                </td>
            </tr>
            <tr>
                <th>Id Card</th>
                <td><form:input path="idCard"></form:input></td>
            </tr>
            <tr>
                <th>Travel Information</th>
                <td><form:input path="travelInformation">
                    <form:checkbox path="travelInformation" value="plane">Plane</form:checkbox>
                    <form:checkbox path="travelInformation" value="ships">Ships</form:checkbox>
                    <form:checkbox path="travelInformation" value="car">Car</form:checkbox>
                    <form:checkbox path="travelInformation" value="other">Other</form:checkbox>
                </form:input></td>
            </tr>
            <tr>
                <td>
                    <th>Vehicle Number</th>
                    <td><form:input path="vehicleNumber"></form:input></td>
                </td>
                <td>
                    <th>Vehicle Number</th>
                    <td><form:input path="seats"></form:input></td>
                </td>
            </tr>
            <tr>
                <td>
                    <th></th>
                </td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
        </table>
    </form:form>
  </body>
</html>
