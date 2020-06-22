package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.Ex02Repository;

/**
 * 演習2のサービスクラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Service
@Transactional
public class Ex02Service {
	@Autowired
	private Ex02Repository repository;

	/**
	 * 指定の価格以下のホテルを価格の降順で検索.
	 * 
	 * @param price 指定価格
	 * @return 検索結果
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		return repository.searchByLessThanPrice(price);
	}

	/**
	 * 全ホテルを価格の降順で検索.
	 * 
	 * @return 検索結果
	 */
	public List<Hotel> showAll() {
		return repository.findAll();
	}
}
