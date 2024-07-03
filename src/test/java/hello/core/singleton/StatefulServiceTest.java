package hello.core.singleton;

import hello.core.CoreApplication;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);
        
        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);
        //ThreadA: A사용자 주문 금액 조회
        int price = statefulService1.getPrice();
        //사용자A는 10000원을 기대했지만 기대와 다르게 20000원 출력
        System.out.println("price = " + price);
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
        
    
         
    }







    static class TestConfig {


        @Bean
        public StatefulService statefulService() {
            return new StatefulService();

        }
    }
}