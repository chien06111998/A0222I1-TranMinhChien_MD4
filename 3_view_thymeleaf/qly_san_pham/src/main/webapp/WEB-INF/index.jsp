<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/3/2022
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>$Title$</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  </head>
  <body>
      <h1>Display all product</h1>
      <a th:href="@{/product/list}">Back to list</a>
      <br>
      <a th:href="@{/product/create}">Add product</a>

      <form th:action="@{/product/search}" method="get">
          <input type="text" name="nameSearch" placeholder="Input name product">
          <input type="submit" value="search">
      </form>
<%--      <div th:if="${mess}">--%>
<%--          <span th:text="${mess}"></span>--%>
<%--      </div>--%>

      <table class="table table-dark table-striped" >
          <thead>
          <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Price</th>
              <th>Note</th>
              <th>Producer</th>
              <th>Action</th>
          </tr>>
          <tbody>

          <tbody th:each= "product, iterStat: ${productList}">
              <tr th:object="${product}">
                  <td th:text="*{id}"></td>
                  <td th:text="*{name}"></td>
                  <td th:text="*{price}"></td>
                  <td th:text="*{note}"></td>
                  <td th:text="*{producer}"></td>
                  <td>
                      <a th:href="@{/product/view/{id}(id=*{id})}">View</a>
                      <a th:href="@{/product/edit/{id}(id=*{id})}">Edit</a>
                      <a th:href="@{/product/delete/{id}(id=*{id})}">Delete</a>
                  </td>
              </tr>
          </tbody>
      </table>
  </body>
</html>
