package tw.per.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.per.allen.model.dto.AuthDto;
import tw.per.allen.model.dto.record.AccountPassword;
import tw.per.allen.service.AuthService;

/**
 * 權限相關
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@GetMapping("/login")
	public AuthDto login(@ModelAttribute AccountPassword info) {
		return authService.login(info);
	}
}
