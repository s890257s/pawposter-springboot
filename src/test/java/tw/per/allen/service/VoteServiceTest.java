package tw.per.allen.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.per.allen.model.enums.VoteState;

@SpringBootTest
class VoteServiceTest {

	@Autowired
	VoteService voteService;

	@Test
	void test() {
		voteService.vote(1, 2, VoteState.LIKE);
	}

}
