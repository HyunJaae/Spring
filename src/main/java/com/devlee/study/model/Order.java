package com.devlee.study.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private Long orderId;

    // XtoOne 연관 관계 매핑 시 fetchType 은 LAZY 로 해야 한다. (N+1 방지를 위해, default 는 EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
