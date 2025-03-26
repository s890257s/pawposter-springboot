package tw.per.allen.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.per.allen.model.dto.PetDto;

@SpringBootTest
class PetServiceTest {

	@Autowired
	PetService petService;

	@Test
	void testCheckVote() {
		List<PetDto> all = petService.getAll();
		petService.checkVote(1, all);
	}

}
