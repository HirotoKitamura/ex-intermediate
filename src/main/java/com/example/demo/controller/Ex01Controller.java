package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.Ex01Service;

@Controller
@RequestMapping("/ex01")
class Ex01Controller {
	@Autowired
	private Ex01Service service;

	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("teamList", service.showList());
		return "ex01";
	}
}
