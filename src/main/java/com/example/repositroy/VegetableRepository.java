package com.example.repositroy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Vegetable;

@Repository
public class VegetableRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Vegetable> VEGETABLE_ROW_MAPPER = (rs, i) -> {
		Vegetable vegetable = new Vegetable();
		vegetable.setId(rs.getInt("id"));
		vegetable.setName(rs.getString("name"));
		vegetable.setDescription(rs.getString("description"));
		vegetable.setPrice(rs.getInt("price"));
		vegetable.setColor(rs.getString("color"));
		vegetable.setDeleted(rs.getBoolean("deleted"));
		return vegetable;
	};
	
	public List<Vegetable> findAll() {
		String sql = "SELECT id, name, description, price, color, deleted FROM vegetables ORDER BY id";
		List<Vegetable> vegetableList = template.query(sql, VEGETABLE_ROW_MAPPER);
		return vegetableList;
	}
	
	public void insert(Vegetable vegetable) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(vegetable);
		
		String sql = "INSERT INTO vegetables(name, description, price, color, deleted)"
		+ " VALUES(:name, :description, :price, :color, :deleted)";
		
		template.update(sql, param);
	}
}
