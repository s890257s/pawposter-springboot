package tw.per.allen.config;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;

import tw.per.allen.model.entity.Member;
import tw.per.allen.model.entity.Pet;
import tw.per.allen.repository.MemberRepository;
import tw.per.allen.repository.PetRepository;

@Component
public class Initialize {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private PetRepository petRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void onReady() throws Exception {

		inserMemberImage();
		inserPetImage();
	}

	private void inserMemberImage() throws Exception {
		// 塞入會員圖片
		List<Member> members = memberRepository.findAll();
		if (members.get(0).getMemberPhoto() != null) {
			return;
		}

		File file = ResourceUtils.getFile("classpath:assets/images/members");
		File[] files = file.listFiles();

		for (int i = 0; i < members.size(); i++) {
			System.out.println(files[i]);
			byte[] photoContent = Files.readAllBytes(Path.of(files[i].getPath()));
			members.get(i).setMemberPhoto(photoContent);
		}

		System.out.println(members);
		memberRepository.saveAll(members);
	}

	private void inserPetImage() throws Exception {
		List<Pet> pets = petRepository.findAll();
		if (pets.get(0).getPetPhoto() != null) {
			return;
		}

		Map<String, String> typeMap = Map.ofEntries(
				Map.entry("狗", "dog"),
				Map.entry("貓", "cat")

		);

		
		pets.forEach(p -> {
//		ResourceUtils.getFile("classpath:");	
		
		});
	}
}
