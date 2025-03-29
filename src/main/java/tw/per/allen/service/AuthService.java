package tw.per.allen.service;

import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.per.allen.exception.LoginFailException;
import tw.per.allen.model.dto.AuthDto;
import tw.per.allen.model.dto.record.AccountPassword;
import tw.per.allen.model.entity.Member;
import tw.per.allen.repository.MemberRepository;

@Service
public class AuthService {

	@Autowired
	private MemberRepository memberRepository;

	public AuthDto login(AccountPassword info) {

		if (Strings.isBlank(info.account()) || Strings.isBlank(info.password())) {
			throw new RuntimeException("帳號或密碼不得為空");
		}

		Member member = memberRepository.findByMemberAccount(info.account());

		LoginFailException loginFail = new LoginFailException("帳號或密碼錯誤");

		if (member == null) {
			throw loginFail;
		}

		// 檢查大小寫
		if (!Objects.equals(info.account(), member.getMemberAccount())) {
			throw loginFail;
		}

		// 檢查密碼
		if (!Objects.equals(info.password(), member.getMemberPassword())) {
			throw loginFail;
		}

		return new AuthDto(member);
	}

}
