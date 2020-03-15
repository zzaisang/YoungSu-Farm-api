package com.yongsu.farm.domain.user;

import com.yongsu.farm.domain.common.YesNo;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-03-15
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private YesNo representYn;

    private String zoneCode;

    private String basicAddress;

    private String detailAddress;

    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Builder
    public UserAddress(YesNo representYn, String zoneCode, String basicAddress, String detailAddress, OffsetDateTime createdAt) {
        this.representYn = representYn;
        this.zoneCode = zoneCode;
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
        this.createdAt = createdAt;
    }
}
