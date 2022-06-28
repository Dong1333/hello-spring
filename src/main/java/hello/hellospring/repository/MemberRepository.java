package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원이 저장소에 저장이 됨
    Optional<Member> findById(Long id); // 방금 그 아이디로 회원을 찾는거
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장딘 모든 회원 리스트를 반환 해준다.
}
