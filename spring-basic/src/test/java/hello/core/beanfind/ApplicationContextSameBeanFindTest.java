package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        SameBenConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상이면 NoUniqueBeanDefinitionException 예외를 던진다.")
    void findBeanByTypeDuplication() {
        assertThrows(NoUniqueBeanDefinitionException.class,
            () -> applicationContext.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 같은 타입이 둘 이상 있으면, 빈 이름을 지정해야 한다.")
    void findBeanByName() {
        MemberRepository bean = applicationContext.getBean("memberRepository",
            MemberRepository.class);

        assertThat(bean).isInstanceOf(MemberRepository.class);

        MemberRepository bean1 = applicationContext.getBean("memberRepositoryOther",
            MemberRepository.class);

        assertThat(bean1).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("타입으로 조회 시 등록되지 않은 이름으로 조회하면 NoSuchBeanDefinitionException 예외를 던진다.")
    void findBeanOther() {
        assertThrows(NoSuchBeanDefinitionException.class,
            () -> applicationContext.getBean("memberRepository1",
                MemberRepository.class));
    }

    @Test
    @DisplayName("특정 타입 모두 조회하기")
    void findBeanByType() {
        Map<String, MemberRepository> beansOfType = applicationContext.getBeansOfType(
            MemberRepository.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + "value = " + beansOfType.get(key));
        }

        System.out.println("beansOfType = " + beansOfType);

        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameBenConfig {

        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepositoryOther() {
            return new MemoryMemberRepository();
        }
    }
}
