package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.ClothForm;
import com.example.demo.service.Ex03Service;

/**
 * 課題3のコントローラークラス.
 * 
 * @author hiroto.kitamura
 *
 */
/**
 * @author hiroto.kitamura
 *
 */
@Controller
@RequestMapping("ex03")
public class Ex03Controller {
	@Autowired
	private Ex03Service service;

	@ModelAttribute
	private ClothForm setUpForm() {
		return new ClothForm();
	}

	/**
	 * 検索画面を表示.
	 * 
	 * @return 検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "ex03";
	}

	/**
	 * 検索結果を表示.
	 * 
	 * @param model     リクエストスコープ
	 * @param clothForm フォームから受け取った情報
	 * @return 検索画面
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("result")
	public String result(Model model, ClothForm clothForm) {
		Map map = service.searchByColorAndGender(clothForm.getColor(), clothForm.getGender());
		model.addAllAttributes(map);
		model.addAttribute("gender", clothForm.getGender());
		return "ex03";
	}
}
