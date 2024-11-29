package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        ExtendConfig.class);

    @Test
    @DisplayName("부모 타입으로 조 시, 자식이 둘 이상이 있으면 중복 오류가 발생한다.")
    void findByExtendBean() {
        assertThrows(NoUniqueBeanDefinitionException.class,
            () -> applicationContext.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanByParentTypeName() {
        RateDiscountPolicy rateDisCountPolicy = applicationContext.getBean(
            RateDiscountPolicy.class);

        assertThat(rateDisCountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBeanBySubType() {
        DiscountPolicy rateDisCountPolicy = applicationContext.getBean("rateDisCountPolicy",
            DiscountPolicy.class);

        assertThat(rateDisCountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 조회")
    void findBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(
            DiscountPolicy.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value" + beansOfType.get(key));
        }

        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Object 타입으로 모두 조회")
    void findBeanByObjectType() {
        Map<String, Object> beansOfType = applicationContext.getBeansOfType(
            Object.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value" + beansOfType.get(key));
        }

        assertThat(beansOfType.size()).isEqualTo(16);
    }

    @Configuration
    static class ExtendConfig {

        @Bean
        public DiscountPolicy rateDisCountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDisCountPolicy() {
            return new FixDiscountPolicy();
        }
    }

}
