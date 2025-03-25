package tw.per.allen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.per.allen.repository.MemberRepository;

@SpringBootTest
class PawposterSpringbootApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	void contextLoads() {
		memberRepository.findById(1).ifPresent(m -> {
			memberRepository.save(m);
		});
	}

}
