package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.Ex02Service;

/**
 * 課題2のコントローラークラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Controller
@RequestMapping("ex02")
public class Ex02Controller {
	@Autowired
	private Ex02Service service;

	@RequestMapping("")
	public String index() {
		return "ex02";
	}
}
