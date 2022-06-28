package hello.hellospring.domain;

public class Member {
    private Long id; // 데이터베이스든 시스템이 정해주는 아이디 임의의 값
    private String name; // 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
