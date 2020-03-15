package com.yongsu.farm.domain.policy;

import com.yongsu.farm.domain.product.Product;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = "productList")
public class PackagePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PackageType packageType;

    private int packageVolume;

    @Enumerated(EnumType.STRING)
    private PackageVolumeType packageVolumeType;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    private int minUnitCnt;

    private int maxUnitCnt;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "packagePolicy", cascade = CascadeType.PERSIST)
    private List<Product> productList = new ArrayList<>();

    @Builder
    public PackagePolicy(PackageType packageType, int packageVolume, PackageVolumeType packageVolumeType, UnitType unitType, int minUnitCnt, int maxUnitCnt, OffsetDateTime createdAt) {
        this.packageType = packageType;
        this.packageVolume = packageVolume;
        this.packageVolumeType = packageVolumeType;
        this.unitType = unitType;
        this.minUnitCnt = minUnitCnt;
        this.maxUnitCnt = maxUnitCnt;
        this.createdAt = createdAt;
    }
}
