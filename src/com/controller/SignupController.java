package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String eContact = request.getParameter("contact");
		long contact = 0;

		boolean isError = false;
		if (firstName == null || firstName.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstNameError", "<font color='red'>Please enter first name</font>");
		} else {
			request.setAttribute("firstNameValue", firstName);
		}

		if (lastName == null || lastName.trim().length() == 0) {
			isError = true;
			request.setAttribute("lastNameError", "<font color='red'>Please enter last name</font>");
		} else {
			request.setAttribute("lastNameValue", lastName);
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please enter email");
		} else {
			request.setAttribute("emailValue", email);
		}
		if (password == null || password.trim().length() == 0) {
			isError = true;
			request.setAttribute("passwordError", "Please enter password");
		} else {
			request.setAttribute("passwordValue", password);
		}

		if (eContact == null || eContact.trim().length() == 0) {
			isError = true;
			request.setAttribute("contactError", "<font color = 'red'>Please Enter contact</font>");
		} else {
			try {
				System.out.println(eContact);
				contact = Long.parseLong(eContact);
				request.setAttribute("contactValue", contact);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Contact not parsed ");
				e.printStackTrace();
			}
		}

		if (gender == null) {
			isError = true;
			request.setAttribute("genderError", "Please select gender");
		} else {
			request.setAttribute("genderValue", gender);
		}

		RequestDispatcher rd = null;
		if (isError == true) {
			rd = request.getRequestDispatcher("Signup.jsp");
		} else {

			UserDao userDao = new UserDao();

			UserBean userBean = new UserBean();

			userBean.setFirstName(firstName);
			userBean.setLastName(lastName);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setContact(contact);
			userBean.setUserType("customer");

			userDao.insertUser(userBean);

			request.setAttribute("msg", "Signup done...");
			rd = request.getRequestDispatcher("Login.jsp");
		}
		rd.forward(request, response);

//		System.out.println(firstName);
//		System.out.println(lastName);
//
//		request.setAttribute("firstName", firstName);
//		request.setAttribute("lastName", lastName);
//		request.setAttribute("gender", gender);

//
//		System.out.println("hello from signupcontroller");

	}
}
