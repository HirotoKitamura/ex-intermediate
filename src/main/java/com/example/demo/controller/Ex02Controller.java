package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Hotel;
import com.example.demo.form.PriceForm;
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

	@ModelAttribute
	private PriceForm setUpPriceForm() {
		return new PriceForm();
	}

	/**
	 * 検索画面を表示.
	 * 
	 * @return 検索画面のHTMLファイル
	 */
	@RequestMapping("")
	public String index() {
		return "ex02";
	}

	/**
	 * 検索結果を表示.
	 * 
	 * @param priceForm 入力された価格が入るフォーム
	 * @param model     リクエストスコープ 検索結果のリストとエラー文が入る
	 * @return 検索画面のHTMLファイル
	 */
	@RequestMapping("result")
	public String result(PriceForm priceForm, Model model) {
		try {
			int intPrice = Integer.parseInt(priceForm.getPrice());
			List<Hotel> hotelList = service.searchByLessThanPrice(intPrice);
			if (hotelList.size() == 0) {
				model.addAttribute("errors", "検索結果が1件もありません");
			} else {
				model.addAttribute("hotelList", hotelList);
			}
		} catch (Exception e) {
			if ("".equals(priceForm.getPrice())) {
				model.addAttribute("hotelList", service.showAll());
			} else {
				model.addAttribute("errors", "入力が不正です");
			}
		}

		return "ex02";
	}
}
