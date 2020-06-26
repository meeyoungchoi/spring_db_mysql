package com.spring.db2.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db2.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {

	public class ScoreMapper implements RowMapper<ScoreVO> {

		@Override
		public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {//sql실행결과물과 데이터가 몇줄 조회가 되었는지를 달라(jDBC템플릿이 준다)
			ScoreVO score = new ScoreVO();
			score.setStuId(rs.getInt("stu_id"));//컬럼값을 집어넣는다
			score.setStuName(rs.getString("stu_name"));
			score.setKor(rs.getInt("kor"));
			score.setEng(rs.getInt("eng"));
			score.setMath(rs.getInt("math"));
			score.setTotal(rs.getInt("total"));
			score.setAverage(rs.getDouble("average"));
			
			
			return score;
		}


		
	}
	
	
	@Autowired
	private JdbcTemplate template;

	
	
	
	
	@Override
	public void insertScore(ScoreVO scores) {
		String sql = "INSERT INTO scores3 "
				+ "(stu_name, kor, eng, math, total, average) "
				+ "VALUES(?,?,?,?,?,?)";

		//jdbc템플릿 객체 사용
		//빈등록을 해놨기때문에 갖고오면된다
		//Object...args => ...은 가변인수(갯수가 지정되지 않았다 매개변수의 타입이 프로젝트마다 다르기때문에 타입이 오브젝트 타입이다)

		//처음매개변수는 String타입의 sql, 매개변수(?에 채울값)
		template.update(sql, scores.getStuName(), scores.getKor(), 
				scores.getEng(), scores.getMath(), scores.getTotal(), 
				scores.getAverage());



	}

	@Override
	public List<ScoreVO> selectAllScores() {
	
		String sql = "SELECT * FROM scores3";
		
		



		 return template.query(sql, new ScoreMapper());
	}

	@Override
	public void deleteScore(int stuNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
