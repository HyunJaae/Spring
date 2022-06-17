## 🌈 Singleton Pattern
### 문제 상황
![](https://hongchangsub.com/content/images/2021/08/-----------2021-08-11------5.27.25.png)
- 동일한 요청이 서로 다른 클라이언트로부터 동시에 들어올 수 있다.
- 요청이 들어오면 객체를 만들어서 메모리를 사용하게 되는데 만약 동일한 요청들을 모두 다른 메모리 공간에 할당 시켜 응답하게 되면 메모리 공간이 낭비된다.
```java
// 싱글톤 패턴이 없는 경우
public class SingletonTest {
    // 객체 요청 때마다 새로 생성하는 문제점을 가진다.
    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출 할 때마다 객체를 생성(문제점)
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
```
```shell
# 참조 값이 다르다.
memberService1 = com.devlee.study.MemberService@35f22eef
memberService2 = com.devlee.study.MemberService@5d20195b
```

> 위 같은 문제점을 해결하기 위한 방안으로 **싱글톤 패턴**을 적용시킨다.

### 싱글톤 패턴 특징 및 예제

- 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
- 해당되는 인스턴스에 대해서 static을 통해 최초 1번만 메모리를 할당시키며 이후 해당 인스턴스에 대한 호출이 생길 때 마다 최초로 생긴 인스턴스를 사용
- 그래서 `private`를 사용해 객체 인스턴스를 2개 이상 생성하지 못하도록 막는다.
```java
public class SingletonService {
    //static 객체라서 클래스레벨로 딱 한개만 생성된다.
    //Lazy-init 방식은 아니다 => static 으로 바로 생성해버림
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //Using Private Constructor to prevent making new instance
    private SingletonService() {}

    public void logic() {
        System.out.println("singleton logic");
    }

}
```
```shell
singletonService1 = com.devlee.study.service.SingletonService@1e3dc24f
singletonService2 = com.devlee.study.service.SingletonService@1e3dc24f
```
- static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
- 해당 객체 인스턴스가 필요하면 오직 getInstance()메서드를 통해서만 접근 할 수 있다.
- 해당 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
- 생성자를 private로 막아서 instance가 여러개 생성되는것을 막는다.

위와 같은 과정으로 싱글톤 패턴을 적용 시킬 수 있다.

### 싱글톤 패턴의 단점
- 싱글톤 패턴을 사용하는 다른 객체들간의 결합도(의존성)이 높아지기 때문에 객체 지향 설계 원칙에 위배된다. 즉, 클라이언트가 구체 클래스에 의존한다.
- 내부 설계를 변경하거나 초기화하기가 어렵다.
- private 생성자를 사용하기 때문에 자식 클래스를 만들기 어렵다.
- 결론적으로 유연하지 않다라는 큰 단점이 존재한다.

## 🏄‍♂️ Singleton Container (Spring Container)
- 스프링 컨테이너는 싱글톤 패턴을 적용하지 않아도, 객체 인스턴스를 싱글톤으로 관리한다.
- 그래서 스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 객체 인스턴스를 싱글톤(1개만 생성)으로 관리한다.
- 지금까지 써 왔던 스프링 빈이 바로 싱글톤 패턴으로 관리되는 빈이다.
```java
@Test
@DisplayName("스프링 컨테이너와 싱글톤")
  void springContainer() {
      ApplicationContext ac = new
  AnnotationConfigApplicationContext(AppConfig.class);
	//1. 조회: 호출할 때 마다 같은 객체를 반환
      MemberService memberService1 = ac.getBean("memberService",
  MemberService.class);
	//2. 조회: 호출할 때 마다 같은 객체를 반환
      MemberService memberService2 = ac.getBean("memberService",
  MemberService.class);
	//참조값이 같은 것을 확인
System.out.println("memberService1 = " + memberService1); System.out.println("memberService2 = " + memberService2);
      //memberService1 == memberService2
      assertThat(memberService1).isSameAs(memberService2);
  }
```
- 위의 테스트 코드도 다른 클라이언트의 요청에 동일한 static 객체를 반환한다.
### 싱글톤 방식의 주의점
- 싱글톤 패턴 또는 싱글톤 컨테이너든 객체 인스턴스를 하나만 생성해서 사용하는 방식의 경우 여러 클라이언트가 하나의 객체를 공유하기 때문에 해당 객체를 상태를 유지시키는 구조로 설계해서는 안된다.
- 위에서 언급한 싱글톤 패턴의 단점과도 일맥상통하는 부분이며, 조금 더 풀어서 설명하면 특정 클라이언트가 특정값을 변경할 수 있게 하며 안된다는 뜻이다.

해당 문제점을 가지는 예시코드를 작성해보자.
```java
public class StatefulService {
    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; //여기가 문제!
    }
    
    public int getPrice() {
        return price;
    }
}
```
```java
class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /*
        * A가 주문을하고 주문금액 조회하는 사이에
        * B가 주문을 해버린 상황
        * */

        //Thread A : A 사용자가 10000원 주문
        statefulService1.order("userA",10000);
        //Thread B : B 사용자가 10000원 주문
        statefulService2.order("userB",20000);

        //Thread A : A 사용자가 주문금액조회
        int price = statefulService1.getPrice();
        System.out.println("A의 price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(statefulService2.getPrice());
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
```
- 위 테스트의 결과는 아래처럼 A 사용자의 주문금액(10000원)이 B 사용자의 주문 금액으로 할당 되어지는 오류를 보여준다.
- 즉 이러한 구조가 클라이언트가 특정 값을 변경할 수 있게 하는 구조, stateful한 구조라 할 수 있다.
- 그렇기에 공유 필드는 항상 조심해서 로직을 처리해야 하며, 스프링 빈은 항상 무상태로 설계해야 한다

## 🙇🏻 Reference 🙇🏻
[브리도의 개발일지](https://hongchangsub.com/springcore5/)
