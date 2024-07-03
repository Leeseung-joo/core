package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import static javax.management.remote.JMXConnectorFactory.connect;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        init();
        call("초기화 연결 메시지");

    }

    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작시 호출
    @PostConstruct
    public void init(){
        System.out.println("connect: " + url);
    }
    //서비스 종료시 호출
    @PreDestroy
    public void close(){
        System.out.println("close: " + url);
    }
    public void call(String message){
        System.out.println("call: " + url + " message " + message);

    }
}
