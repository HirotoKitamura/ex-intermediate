package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hotel;

/**
 * ホテルのリポジトリクラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Repository
public class Ex02Repository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * ホテルのRowMapper.
	 */
	private final static RowMapper<Hotel> HOTEL_ROWMAPPER = (rs, i) -> {
		return new Hotel(rs.getInt("id"), rs.getString("area_name"), rs.getString("hotel_name"),
				rs.getString("address"), rs.getString("nearest_station"), rs.getInt("price"), rs.getString("parking"));
	};

	/**
	 * ある価格以下のホテルを価格の降順で検索.
	 * 
	 * @param price 最高価格
	 * @return 検索結果
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				+ "FROM hotels WHERE price <= :price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		return template.query(sql, param, HOTEL_ROWMAPPER);
	}

	/**
	 * 全ホテルを価格の降順で検索.
	 * 
	 * @return 検索結果
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking "
				+ "FROM hotels ORDER BY price DESC;";
		return template.query(sql, HOTEL_ROWMAPPER);
	}
}
