package org.itstep.bankomat.servlet;

import org.itstep.bankomat.dao.DbManager;
import org.itstep.bankomat.model.CityBankAccount;
import org.itstep.bankomat.model.NationalBankAccount;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String pincode = request.getParameter("pincode");

        CityBankAccount cityBankAccount = null;

        try {
            cityBankAccount = DbManager.getCBAByAccountNumber(accountNumber);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        NationalBankAccount nationalBankAccount = null;

        try {
            nationalBankAccount = DbManager.getNBAByAccountNumber(accountNumber);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String redirect = "/login?error=1"; // если юзера нет

        if (cityBankAccount != null && nationalBankAccount == null) {
            if (cityBankAccount.getPinCode().equals(pincode)) {
                redirect = "/home";
                HttpSession session = request.getSession();
                System.out.println(cityBankAccount);
                session.setAttribute("CITYBANK", cityBankAccount);
            } else {
                redirect = "/login?email=" + cityBankAccount.getAccountNumber() + "&error=2";
            }
        } else if (nationalBankAccount != null && cityBankAccount == null) {
            if (nationalBankAccount.getPinCode().equals(pincode)) {
                redirect = "/home";
                //HttpSession session = request.getSession();
                System.out.println(nationalBankAccount);
                request.getSession().setAttribute("NATIONALBANK", nationalBankAccount);
            } else {
                redirect = "/login?email=" + nationalBankAccount.getAccountNumber() + "&error=2";
            }
        }

        response.sendRedirect(redirect);
    }
}
