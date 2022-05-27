package com.kb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.domain.MemberVO;
import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberPageDTO;
import com.kb.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member/*")
@AllArgsConstructor // 여기에 필드에 쓴 모든생성자만 만들어줌. 이게 없으면 service가 null로 찍혀서 nullpointex 생김.
public class MemberController {

	private MemberService service;

//	@GetMapping("list") // get 방식.
//	public void list(Model model) {
//		log.info("목록");
//		model.addAttribute("list", service.getList()); // view에다가 값을 던진다.(model을 이용)
//	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)

	public void list(MemberCriteria cri, Model model) {
		log.info(cri);
		model.addAttribute("list", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new MemberPageDTO(service.getListWithCnt(cri), cri));
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)

	public void register() {

	}
	/*
	 * 혹은 public String register() { return "board/register"; }
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)

	public String register(MemberVO board, RedirectAttributes rttr) {
		service.register(board);

		return "redirect:/member/list";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	/* public void get(int num) { */
	public void get(@RequestParam("num") int num, Model model) {
		model.addAttribute("member", service.get(num)); // 
		// "member" => 원래 board 였음
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)

	public String get(MemberVO board) {

		boolean result = service.modify(board);
		if (result) {
			return "redirect:/member/list";
		} else {
			return "redirect:/member/get?num=" + board.getNum();
		}

	}

	@RequestMapping(value = "/remove", method = RequestMethod.GET)

	public String remove(@RequestParam("num") int num) {
		service.remove(num);

		return "redirect:/member/list";
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)

	public String remove(MemberVO board) {
		service.remove(board.getNum());

		return "redirect:/member/list";
	}
}
