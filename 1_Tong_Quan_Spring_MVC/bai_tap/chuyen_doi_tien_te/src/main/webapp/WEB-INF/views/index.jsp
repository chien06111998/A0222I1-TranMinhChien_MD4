<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/21/2022
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Chuyển đổi tiền tệ</h1>
  <form method="post">
        <div class="mb-3">
            <label>USD:</label>
            <input type="number" class="form-control" name="usd" id="exampleInputNuber1" aria-describedby="usd">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
         <h2>Result: ${mess}</h2>
    </form>
  </body>
</html>
