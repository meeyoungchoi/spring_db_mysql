package com.spring.db2.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.db2.model.ScoreVO;
import com.spring.db2.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreController {
	
	@Autowired
	private IScoreService service;
	
	
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register: GET");
		return "score/write-form";
	}
	
	//점수등록을 처리하는 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO scores) {
	
		System.out.println("/score/register: POST");
		System.out.println("controller param: " + scores);
		
	
		service.insertScore(scores);
		
		return "score/write-result";
	}
	
	//���� ��ü ��ȸ�� ó���ϴ� ��û �޼���
		@GetMapping("/list")
		public void list(Model model) {
			System.out.println("/score/list: GET");
			
			//���񽺰� dao���� ���� ��û
			//List<ScoreVO> list = service.selectAllScores();
			
			//model�� ����ؼ� list.jsp�� �Ѱ��ش�
			//model.addAttribute("slist", list);
			//���
			model.addAttribute("slist", service.selectAllScores());
			
		}
	
	

	
	
}
