<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="main.css"  rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/reg.do" method="post" class="reg-form">
  <div class="mb-3">
    <label for="exampleInputName" class="form-label">Name</label>
    <input type="text" class="form-control" name="fname" >
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label" >Email</label>
    <input type="email" class="form-control" name="uemail">
  </div>
  <div class="mb-3">
    <label for="exampleInputPhone" class="form-label">Phone number</label>
    <input type="number" class="form-control" name="phnumber">
  </div>
  <div class="mb-3"> <label for="exampleInputName" class="form-label">Gender</label>
  <div class="form-check">
  <input class="form-check-input" type="radio" name="gender" value="male">
  <label class="form-check-label" for="flexRadioDefault1">
   Male 
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" name="gender" value="female">
  <label class="form-check-label" for="flexRadioDefault1">
   Female
  </label>
</div>
</div>
<div class="mb-3"> <label for="exampleInputName" class="form-label">Courses</label>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="Java 11" name="course">
  <label class="form-check-label" for="flexCheckDefault">
    Java 11
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="Servlet" name="course">
  <label class="form-check-label" for="flexCheckDefault">
    Servlet
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="JSP" name="course">
  <label class="form-check-label" for="flexCheckDefault">
    JSP
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="JDBC" name="course">
  <label class="form-check-label" for="flexCheckDefault">
    JDBC
  </label>
</div>
</div>
<select class="form-select" name="timing">
  <option selected>Select the timing</option>
  <option value="7 Am to 9 Am">7 Am to 9 Am</option>
  <option value="7 Pm to 9 Pm">7 Pm to 9 Pm</option>
</select>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>