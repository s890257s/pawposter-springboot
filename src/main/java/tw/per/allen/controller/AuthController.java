package tw.per.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import tw.per.allen.model.dto.AuthDto;
import tw.per.allen.model.dto.record.AccountPassword;
import tw.per.allen.service.AuthService;
import tw.per.allen.utils.JwtUtil;

/**
 * 權限相關
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public AuthDto login(@RequestBody AccountPassword info) {
		return authService.login(info);
	}

	@GetMapping("/test")
	public String login() {
		return JwtUtil.generateToken("1");
	}

	@GetMapping("/test/session")
	public void login(HttpSession session) {
		session.setAttribute("loggedInMember", "1");
	}

	@GetMapping("/who")
	public String test(HttpSession session) {
		return "你是: %s".formatted(session.getAttribute("loggedInMember"));
	}
}
