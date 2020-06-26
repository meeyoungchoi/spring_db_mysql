package com.spring.db2.service;

import java.util.List;

import com.spring.db2.model.ScoreVO;

public interface IScoreService {
	//정렬 ctrl a + ctrl i
		//점수 등록기능
		void insertScore(ScoreVO scores);

		//점수 전체 조회 기능
		List<ScoreVO> selectAllScores();

		//점수 삭제 기능
		void deleteScore(int stuNum);//저장된 순서


		//점수 개별 조회 기능
		ScoreVO selectOne(int stuNum);

}
