package com.kb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kb.domain.AuthorVO;
import com.kb.domain.MemberVO;
import com.kb.domain.SampleVO;
import com.kb.service.MemberService;
import com.kb.service.MemberServiceImpl;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
//↑명시를 안하면 파일을 찾을 수가 없다.
@Controller
@RequestMapping("/data/*")
@Log4j

//json 으로 파일을 받는 법.
//클라이언트를 쉬게해줌
public class RESTController {

	@Setter(onMethod_ = @Autowired)
	MemberService service;

	// 단순문자
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {

		log.info(MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	// daga/getText.json => json 으로 받는다.

	// 객체타입 리턴
	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {

		return new SampleVO(113, "스타", "로드");
	}

	// 컬렉션 타입 리턴
	@GetMapping(value = "/getSample2")
	public List<SampleVO> getSample2() {

		List<SampleVO> list = new ArrayList<SampleVO>();

		for (int i = 0; i < 10; i++) {
			list.add((new SampleVO(i, "스타" + i, "로드" + i)));
		}
		return list;
	}

	// 맵(Map(Key, Value)
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("first", new SampleVO(113, "스타", "로드"));
		map.put("second", new SampleVO(103, "스타", "로드"));
		return map;
	}

	// ResponseEntity 타입
	@GetMapping(value = "/check", params = { "height", "weight" }) // java에서는 대괄호 대신 중괄호를 사용한다.
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);

		ResponseEntity<SampleVO> result = null;

		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}

	// 주소를 이용해서 글을 보낼 수 있다. data/product/적을 카테고리 / 적을 id
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] { "category: " + cat, "productid: " + pid };
	}

	@GetMapping("/members/{num}")
	public MemberVO read(@PathVariable("num") Integer num) {

		return service.get(num);
	}

	@PutMapping("/members/{num}")
	public boolean update(@PathVariable("num") Integer num, @RequestBody MemberVO member) {
		member.setNum(num);

		return service.modify(member);
	}

	@DeleteMapping("/member/{num}")
	public boolean delete(@PathVariable("num") Integer num) {

		return service.remove(num);
	}

	@RequestMapping(value = "/members/new", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED) // 이게 없으면 200이 뜬다. 200은 기본.
	public String membersNew(@RequestBody MemberVO member) {

		List<AuthorVO> list = new ArrayList<AuthorVO>();

		AuthorVO authorvo = new AuthorVO();
		authorvo.setUid(member.getUid());
		authorvo.setAuthority("ROLE_MEMBER");

		list.add(authorvo);

		member.setAuthList(list);

		log.info(member);
		service.register(member);
		return "OK";

	}
}
