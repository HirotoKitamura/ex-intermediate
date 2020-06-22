package com.example.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Team;

/**
 * 野球チームのリポジトリクラス.
 * 
 * @author hiroto.kitamura
 *
 */
@Repository
public class Ex01Repository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * TeamクラスのRowMapper.
	 */
	private static final RowMapper<Team> TEAM_ROWMAPPER = (rs, i) -> {
		Date inauguration = Date
				.valueOf(rs.getString("inauguration").replace("年", "-").replace("月", "-").replace("日", ""));
		return new Team(rs.getInt("id"), rs.getString("league_name"), rs.getString("team_name"),
				rs.getString("headquarters"), inauguration, rs.getString("history"));
	};

	/**
	 * チームIDからチーム情報を取得.
	 * 
	 * @param id チームID
	 * @return IDに該当するチームの情報 該当するチームがない場合はnull
	 */
	public Team load(Integer id) {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		List<Team> teamList = template.query(sql, param, TEAM_ROWMAPPER);
		if (teamList.size() == 0) {
			return null;
		}
		return teamList.get(0);
	}

	/**
	 * 全チームの情報を取得し、チームID順に並べる.
	 * 
	 * @return 全チームの情報のリスト
	 */
	public List<Team> findAll() {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM teams ORDER BY id;";
		return template.query(sql, TEAM_ROWMAPPER);
	}
}
