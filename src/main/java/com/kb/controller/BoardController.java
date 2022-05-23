package com.kb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.domain.BoardVO;
import com.kb.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
@AllArgsConstructor // 여기에 필드에 쓴 모든생성자만 만들어줌. 이게 없으면 service가 null로 찍혀서 nullpointex 생김.
public class BoardController {

	private BoardService service;

	@GetMapping("list") // get 방식.
	public void list(Model model) {
		log.info("목록");
		model.addAttribute("list", service.getList()); // view에다가 값을 던진다.(model을 이용)
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void register() {

	}
	/*
	 * 혹은 public String register() { return "board/register"; }
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	/* public void get(int bno) { */
	public void get(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("board", service.get(bno)); // 해당하는 한 행을 가져온다.
		// @RequestParam("bno2") 괄호 안의 단어가 페이지 상단 글자와 연관이 있다.
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)

	public String get(BoardVO board) {

		boolean result = service.modify(board);
		if (result) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/get?bno=" + board.getBno();
		}

	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)

	public String remove(@RequestParam("bno") int bno) {
		service.remove(bno);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)

	public String remove(BoardVO board) {
		service.remove(board.getBno());

		return "redirect:/board/list";
	}
}
