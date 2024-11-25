package hello.core.order;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    private OrderService orderService = new OrderServiceImpl();
    private MemberService memberService = new MemberServiceImpl();
    private Member member;

    Long memberId = 1L;

    @BeforeEach
    void setUp() {
        member = new Member(memberId, "memberA", Grade.VIP);
    }

    @Test
    void order() {
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
        assertThat(order.calculatePrice()).isEqualTo(9000);
    }
}
