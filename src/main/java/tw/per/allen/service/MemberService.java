package tw.per.allen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.per.allen.model.dto.MemberDto;
import tw.per.allen.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public List<MemberDto> getAll() {
		List<MemberDto> members = memberRepository.findAll().stream().map(MemberDto::new).toList();
		return members;
	}

	public MemberDto getById(Integer id) {
		return memberRepository.findById(id).map(MemberDto::new).orElseThrow(() -> new RuntimeException("找不到會員"));
	}

}
