package com.example.demo.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.Colors;
import com.example.demo.domain.Cloth;
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

	@Autowired
	private ServletContext application;

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
		application.setAttribute("colors", Colors.values());
		return "ex03";
	}

	/**
	 * 検索結果を表示.
	 * 
	 * @param model     リクエストスコープ
	 * @param clothForm フォームから受け取った情報
	 * @return 検索画面
	 */
	@RequestMapping("result")
	public String result(Model model, ClothForm clothForm) {
		if (clothForm.getColor() == null) {
			return "redirect:/ex03";
		}
		List<Cloth> clothList = service.searchByColorAndGender(clothForm.getColor(), clothForm.getGender());
		model.addAttribute("clothList", clothList);
		if (clothList.size() == 0) {
			model.addAttribute("errors", "検索結果が1件もありません");
		}
		return "ex03";
	}
}
