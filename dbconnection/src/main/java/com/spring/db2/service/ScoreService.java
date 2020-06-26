package com.spring.db2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db2.model.ScoreVO;
import com.spring.db2.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {

	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScore(ScoreVO scores) {
		// TODO Auto-generated method stub
		scores.calcData();
		dao.insertScore(scores);
		
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		// TODO Auto-generated method stub
		return dao.selectAllScores();
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
