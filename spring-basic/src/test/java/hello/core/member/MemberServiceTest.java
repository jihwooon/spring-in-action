package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    private MemberService memberService;
    private Member member;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

        member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
    }

    @Test
    void findMember() {
        Member findMember = memberService.findMember(1L);

        assertThat(findMember).isEqualTo(findMember);
    }
}
