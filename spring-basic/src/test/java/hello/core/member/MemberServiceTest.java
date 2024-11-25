package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberServiceImpl memberService = new MemberServiceImpl();
    Member member;

    @BeforeEach
    void setUp() {
        member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
    }

    @Test
    void findMember() {
        Member findMember = memberService.findMember(1L);

        assertThat(findMember).isEqualTo(findMember);
    }
}
