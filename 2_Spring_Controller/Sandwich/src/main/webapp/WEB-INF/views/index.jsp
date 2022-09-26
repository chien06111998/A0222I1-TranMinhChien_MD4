<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/23/2022
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
        hr {
            float: left;
           width: 450px;
        }
    </style>
  </head>
  <body>
      <h1>Sandwich Condiments.</h1>
      <form action="" method="post">
        <input type="checkbox" id="vehicle1" name="spice" value="Lettuce">
        <label for="vehicle1">Lettuce</label>
        <input type="checkbox" id="vehicle2" name="spice" value="Tomato">
        <label for="vehicle2">Tomato</label>
        <input type="checkbox" id="vehicle3" name="spice" value="Mustard">
        <label for="vehicle3">Mustard</label>
        <input type="checkbox" id="vehicle4" name="spice" value="Sprouts">
        <label for="vehicle3">Sprouts</label><br><br>
        <input type="submit" value="Submit">
      </form>
      <hr>
      <br>
      <h3>Sandwich: ${mess}</h3>
  </body>
</html>
