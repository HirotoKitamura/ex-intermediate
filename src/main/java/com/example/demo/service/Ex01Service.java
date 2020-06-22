package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Team;
import com.example.demo.repository.Ex01Repository;

/**
 * 野球チームのサービスクラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Service
@Transactional
public class Ex01Service {
	@Autowired
	private Ex01Repository repository;

	/**
	 * チームIDからチーム情報を取得.
	 * 
	 * @param id チームID
	 * @return IDに該当するチームの情報 該当するチームがない場合はnull
	 */
	public Team showDetail(Integer id) {
		return repository.load(id);
	}

	/**
	 * 全チームの情報を取得し、チームID順に並べる.
	 * 
	 * @return 全チームの情報のリスト
	 */
	public List<Team> showList() {
		return repository.findAll();
	}
}
