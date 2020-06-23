package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Cloth;

/**
 * 課題3のリポジトリクラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Repository
public class Ex03Repository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * 服のRowMapper.
	 */
	private final static RowMapper<Cloth> CLOTH_ROWMAPPER = (rs, i) -> {
		return new Cloth(rs.getInt("id"), rs.getString("category"), rs.getString("genre"), rs.getInt("gender"),
				rs.getString("color"), rs.getInt("price"), rs.getString("size"));
	};

	/**
	 * 指定された色と性別に該当する衣類を検索.
	 * 
	 * @param color  色
	 * @param gender 性別 男性が0で女性が1
	 * @return 検索結果
	 */
	public List<Cloth> findByColorAndGender(String color, Integer gender) {
		String sql = "SELECT id, category, genre, gender, color, price, size "
				+ "FROM clothes WHERE color = :color AND gender = :gender;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("color", color).addValue("gender", gender);
		return template.query(sql, param, CLOTH_ROWMAPPER);
	}
}
