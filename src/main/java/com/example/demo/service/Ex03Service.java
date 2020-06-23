package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Cloth;
import com.example.demo.repository.Ex03Repository;

/**
 * 課題3のサービスクラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Service
@Transactional
public class Ex03Service {
	@Autowired
	private Ex03Repository repository;

	/**
	 * 指定された色と性別に該当する衣類を検索.
	 * 
	 * @param color  色
	 * @param gender 性別 男性が0で女性が1
	 * @return 検索結果のリストとエラーが入ったMap
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map searchByColorAndGender(String color, Integer gender) {
		Map map = new HashMap<>();
		List<Cloth> clothList = repository.findByColorAndGender(color, gender);
		map.put("clothList", clothList);
		if (clothList.size() == 0) {
			map.put("errors", "検索結果が1件もありません");
		}
		return map;
	}
}
