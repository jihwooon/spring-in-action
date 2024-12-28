package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ProtoTypeBean.class);

        System.out.println("find prototypeBean1");
        ProtoTypeBean bean1 = context.getBean(ProtoTypeBean.class);

        System.out.println("find prototypeBean2");
        ProtoTypeBean bean2 = context.getBean(ProtoTypeBean.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);

        assertThat(bean1).isNotSameAs(bean2);

        context.close();
    }

    @Scope("prototype")
    @Component
    static class ProtoTypeBean {
        @PostConstruct
        public void init () {
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("ProtoTypeBean.destroy");
        }
    }
}
