package tw.per.allen.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.per.allen.service.MemberService;
import tw.per.allen.utils.JwtUtil;

@Component
public class RequestFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;

	@Autowired
	private MemberService memberService;

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer ")) {
			String jwtToken = header.substring(7);
			String memberId = JwtUtil.getSubject(jwtToken);

			MemberHolder.setMember(memberService.getById(Integer.parseInt(memberId)));
		}

		chain.doFilter(request, response);

		MemberHolder.clear();
	}

}
