package com.example.app.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.controller.SubController;

public class BookDeleteController implements SubController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BookDeleteController's execute() invoke");
		
	}

}
