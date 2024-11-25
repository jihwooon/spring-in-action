package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    MemberService memberService = new MemberServiceImpl();
    DiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 회원이 아닌 경우 할인 금액이 적용되지 않는다.")
    void vip_x() {
        Member member = new Member(1L, "memberA", Grade.BASIC);
        memberService.join(member);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}
