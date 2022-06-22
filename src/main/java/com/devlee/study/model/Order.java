package com.devlee.study.model;

import com.devlee.study.exception.CustomException;
import com.devlee.study.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Entity 생성 시 주의점

@Entity
@Getter
@Setter  // 불변성 보장이 어렵다.
@RequiredArgsConstructor
@Table(name = "order") // 테이블, 컬럼명 생성 전략 (대문자 -> 소문자)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id") // 테이블, 컬럼명 생성 전략 (카멜케이스 -> 언더스코어)
    private Long orderId;

    @Column(name = "order_count")
    private int orderCount;

    // XtoOne 연관 관계 매핑 시 fetchType 은 LAZY 로 해야 한다. (N+1 방지를 위해, default 는 EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    //==비즈니스 로직 - 핵심 비즈니스 로직은 데이터를 가지고 있는 쪽에 구현한다.==//

    /**
     * 주문 수량 더하기
     */
    public void addOderCount(int orderCount) {
        this.orderCount += orderCount;
    }

    /**
     * 주문 수량 빼기
     */
    public void removeOrderCount(int orderCount) {
        int count = this.orderCount - orderCount;
        if (count < 0) {
            throw new CustomException(ErrorCode.NOT_FOUND_ORDER_ID);
        }
        this.orderCount = count;
    }
}
