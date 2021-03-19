<%@ page import="org.itstep.bankomat.model.CityBankAccount" %>
<%@ page import="org.itstep.bankomat.model.NationalBankAccount" %>
<%
    CityBankAccount cityBankAccount = (CityBankAccount) request.getSession().getAttribute("CITYBANK");
    NationalBankAccount nationalBankAccount = (NationalBankAccount) request.getSession().getAttribute("NATIONALBANK");
%>

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">BANKOMAT</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                    <%
                        if (cityBankAccount != null && nationalBankAccount == null) {

                    %>

                    <li class="nav-item">
                        <a class="nav-link" href="/home">Top up account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Withdraw money</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">View data</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Change pincode</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">View account number</a>
                    </li>


                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Log out</a>
                    </li>

                    <%
                    } else if (nationalBankAccount != null && cityBankAccount == null) {
                    %>

                    <li class="nav-item">
                        <a class="nav-link" href="/home">Top up account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/home">Withdraw money</a>
                    </li>

                    <%
                    } else {
                    %>

                    <li class="nav-item">
                        <a class="nav-link" href="/register">Register</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>

                    <%
                        }
                    %>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

</div>
