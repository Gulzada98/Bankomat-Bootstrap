<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="template/head.jsp" %>

</head>
<body>
<%@include file="template/navbar.jsp" %>

<div class="container mt-5">
    <div class="row">
        <div class="col-sm-4 offset-4">
            <%
                Object error = request.getParameter("error");
                if (error != null && error.equals("1")) {
            %>
            <div class="alert alert-danger">
                <strong>Account doesn't exist!</strong>
            </div>
            <%
                }
            %>

            <%
                if (error != null && error.equals("2")) {
            %>
            <div class="alert alert-warning">
                <strong>Pincode doesn't match!</strong>
            </div>
            <%
                }
            %>
            <form action="login" method="post">
                <div class="form-group">
                    <label>ACCOUNT NUMBER: </label>
                    <input class="form-control" type="text" name="accountNumber" required
                           value="<%=request.getParameter("accountNumber") != null ? request.getParameter("accountNumber"):""%>">
                </div>

                <div class="form-group">
                    <label>PINCODE: </label>
                    <input class="form-control" type="password" name="pincode" required>
                </div>

                <div class="form-group mt-1">
                    <button class="btn btn-success">SIGN IN</button>
                </div>


            </form>
        </div>
    </div>

</div>


</body>
</html>
