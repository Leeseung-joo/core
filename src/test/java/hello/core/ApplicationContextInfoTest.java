package hello.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//junit5부터는 public 안 붙여도 됨.
class ApplicationContextInfoTest {
    //ApplicationContext의 구현체
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //스프링에 등록된 모든 빈 이름을 조회
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); //빈 이름으로 빈 객체를 조회한다.
            System.out.println("name" + beanDefinitionName + " object=" + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
            String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //스프링에 등록된 모든 빈 이름을 조회
            for (String beanDefinitionName : beanDefinitionNames) {
                BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //빈 하나하나에 대한 정보 꺼냄
                if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {//직접 등록한 애플리케이션 빈일 경우
                    Object bean = ac.getBean(beanDefinitionName); //빈 이름으로 빈 객체를 조회한다.
                    System.out.println("name" + beanDefinitionName + " object=" + bean);
                }
        }
    }


}
