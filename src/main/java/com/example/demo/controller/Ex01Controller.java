package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Team;
import com.example.demo.service.Ex01Service;

/**
 * 課題1のコントローラークラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Controller
@RequestMapping("/ex01")
class Ex01Controller {
	@Autowired
	private Ex01Service service;

	/**
	 * トップ画面を表示.
	 * 
	 * @param model リクエストスコープ
	 * @return トップ画面のHTMLファイル
	 */
	@RequestMapping("")
	public String index(Model model) {
		model.addAttribute("teamList", service.showList());
		return "ex01";
	}

	/**
	 * チーム詳細画面を表示.
	 * 
	 * @param id    クリックされたチームのID
	 * @param model リクエストスコープ
	 * @return 詳細画面のHTMLファイル
	 */
	@RequestMapping("detail")
	public String detail(Integer id, Model model) {
		Team team = service.showDetail(id);
		if (team == null) {
			return "errors";
		}
		model.addAttribute("team", team);
		return "ex01-detail";
	}
}
