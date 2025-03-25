package tw.per.allen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.per.allen.model.dto.MemberDto;
import tw.per.allen.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("")
	public List<MemberDto> getAll() {
		return memberService.getAll();
	}

}
