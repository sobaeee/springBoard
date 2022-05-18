package com.kb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kb.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor //여기에 필드에 쓴 모든생성자만 만들어줌. 이게 없으면 service가 null로 찍혀서 nullpointex 생김.
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("list") //get 방식.
	public void list(Model model) {
		log.info("목록");
		model.addAttribute("list", service.getList()); //view에다가 값을 던진다.(model을 이용)
	}
}
