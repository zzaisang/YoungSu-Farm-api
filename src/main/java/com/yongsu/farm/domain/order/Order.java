package com.yongsu.farm.domain.order;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/20
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"orderDetailList"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int userId;

    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private OffsetDateTime modifiedAt;

    private OffsetDateTime createdAt;

    @OneToOne(mappedBy = "order")
    private OrderAddress orderAddress;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private List<OrderProduct> orderProductList = new ArrayList<>();

    @Builder
    public Order(int userId, OrderType orderType, OrderStatus status, OffsetDateTime modifiedAt, OffsetDateTime createdAt) {
        this.userId = userId;
        this.orderType = orderType;
        this.status = status;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }
}
