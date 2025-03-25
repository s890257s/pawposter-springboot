package tw.per.allen.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.per.allen.model.dto.AuthDto;
import tw.per.allen.model.dto.record.AccountPassword;
import tw.per.allen.model.entity.Member;
import tw.per.allen.repository.MemberRepository;
import tw.per.allen.utils.JwtUtil;

@SpringBootTest
public class TestAuthService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	AuthService authService;

	@Test
	void testLoginSuccess() {

		Member m = memberRepository.findById(1).orElse(null);
		if (m == null) {
			return;
		}

		AccountPassword info = new AccountPassword(m.getMemberAccount(), m.getMemberPassword());
		AuthDto login = authService.login(info);

		String memberId = JwtUtil.getSubject(login.getJwtToken());

		assertEquals(m.getMemberId(), Integer.parseInt(memberId)); // 斷言登入 ID 與解析 jwt token 的 ID 相符
	}

	@Test
	void testLoginFail() {
		AccountPassword info = new AccountPassword("whatever", "???");

		assertThatThrownBy(() -> authService.login(info)) // 測試某方法
				.isInstanceOf(RuntimeException.class) // 預期拋出 RuntimeException 錯誤
				.hasMessageContaining("帳號或密碼錯誤"); // 預期包含錯誤訊息
	}

}
