package hello.core.xml;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        GenericXmlApplicationContext genericXmlApplicationContext = new GenericXmlApplicationContext(
            "appConfig.xml");

        MemberService memberService = genericXmlApplicationContext.getBean("memberService",
            MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
