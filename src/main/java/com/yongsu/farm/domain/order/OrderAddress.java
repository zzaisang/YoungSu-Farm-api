package com.yongsu.farm.domain.order;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/20
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "order")
public class OrderAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String zoneCode;

    private String basicAddress;

    private String detailAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryRequestType deliveryRequestType;

    private OffsetDateTime createdAt;

    @OneToOne
    private Order order;

    @Builder
    public OrderAddress(String zoneCode, String basicAddress, String detailAddress, DeliveryRequestType deliveryRequestType, OffsetDateTime createdAt) {
        this.zoneCode = zoneCode;
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
        this.deliveryRequestType = deliveryRequestType;
        this.createdAt = createdAt;
    }
}
