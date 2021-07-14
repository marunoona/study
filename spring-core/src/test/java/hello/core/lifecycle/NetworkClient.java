package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//javax로 시작하는 패키지는 자바 진영에서 공식적으로 지원하는것이기 때문에 스프링이 아니어도 적용이 된다.
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {//implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect :" + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

//    @Override
//    //"의존관계 주입이 끝나면" 이라는 의미이다
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//       connect();
//       call("초기화 메세지 연걸");
//    }
//
//    @Override
//    //스프링 빈이 소멸되기 전에 호출됨
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }


//    public void init() throws Exception {
//        System.out.println("NetworkClient.init");
//       connect();
//       call("초기화 메세지 연걸");
//    }
//
//    public void close() throws Exception {
//        System.out.println("NetworkClient.close");
//        disconnect();
//    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 메세지 연걸");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
