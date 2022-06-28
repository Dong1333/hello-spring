package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // 키는 회원아이디인 long 값은 Member
    private static long sequence = 0L; // 0 1 2 같이 키 값을 생성해준다


    // store 넣기 전에 Meber에 id(이름)를 세팅하고 store에 저장하고 map에 저장이 됨
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // 만역 값이 널이면 옵셔널이라는거로 감싼다
    }



    // 자바의  다를 사용 루프로 돌리는거 필터 멤퍼 람다사용 멤버에서 겟네임이 파라미터로 넘어온 네임이랑 같은지 확인하는거 같은경우만 필터링이 되고 찾으면 반환이 됨 끝까지 돌렸는데 없으면 옵셔널에 널이 포함되서 준다
    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
                .filter(member  ->  member.getName().equals(name))
                .findAny();
    }


    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // map에 Member부분이  sotre.values랑 일치
    }

    public void clearStrore() {
        store.clear();
    }
}
