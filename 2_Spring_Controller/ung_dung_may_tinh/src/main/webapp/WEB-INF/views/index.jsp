<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/23/2022
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <h1>Calculator</h1>
        <form method="post">
          <div class="mb-3">
            <label>Number a:</label>
            <input type="number" class="form-control" name="numA" id="exampleInputNuber1" aria-describedby="text">
          </div>
          <select name="calculation" id="">
            <option value="addition"> + </option>
            <option value="subtraction"> - </option>
            <option value="multiplication"> * </option>
            <option value="division"> / </option>
          </select>
          <div class="mb-3">
            <label>Number b:</label>
            <input type="number" class="form-control" name="numB" id="exampleInputNuber2" aria-describedby="text">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
          <h2>Result: ${mess}</h2>
        </form>
  </body>
</html>
