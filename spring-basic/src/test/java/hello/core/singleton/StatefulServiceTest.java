package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
            TestConfig.class);

        StatefulService bean1 = context.getBean(StatefulService.class);
        StatefulService bean2 = context.getBean(StatefulService.class);

        bean1.order("userA", 10000);
        bean2.order("userB", 20000);

        int price = bean1.getPrice();

        System.out.println("price = " + price);

        assertThat(bean1.getPrice()).isEqualTo(20000);
    }

    @Configuration
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
