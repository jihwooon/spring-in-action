package hello.core.scan.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ComponentFilterAppConfig.class);

        BeanA beanA = context.getBean("beanA", BeanA.class);

        assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class,
            () -> context.getBean("beanB", BeanB.class));
    }

    @Component
    @ComponentScan(
        includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentFilterAppConfig {

    }
}
