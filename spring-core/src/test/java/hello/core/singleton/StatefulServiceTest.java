package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.nimbus.State;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingletonTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // 사용자A가 만원 주문
        statefulService1.order("userA", 10000);
        // 사용자B가 2만원 주문
        statefulService2.order("userB", 20000);

        // 사용자A가 주문한 금액 조회
        int price = statefulService1.getPrice();

        // 만원이 조회되어야 하나 2만원이 조회됨
        Assertions.assertThat(price).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
