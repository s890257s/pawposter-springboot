package tw.per.allen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.per.allen.model.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Member findByMemberAccount(String memberAccount);
}
