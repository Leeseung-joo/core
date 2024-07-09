package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SingletonWithPrototypeTest1 {
    @Test
    void singletonClientUsePrototype(){
        new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);


    }


    static class ClientBean {
        private final PrototypeBean prototypeBean;

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }










    @Scope("prototype")
    static class PrototypeBean{
        private int count = 0;
        public void addCount(){
            count++;
        }
        public int getCount(){
            return count++;
        }
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init"+ this);}
        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}

