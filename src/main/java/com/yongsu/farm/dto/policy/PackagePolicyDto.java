package com.yongsu.farm.dto.policy;

import com.yongsu.farm.domain.policy.PackageVolumeType;
import com.yongsu.farm.domain.policy.UnitType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PackagePolicyDto {

    private String packageTypeName;

    private int packageVolume;

    private PackageVolumeType packageVolumeType;

    private UnitType unitType;

    private String unitTypeString;

    private int minUnitCnt;

    private int maxUnitCnt;

    @Builder
    public PackagePolicyDto(String packageTypeName, int packageVolume, PackageVolumeType packageVolumeType, UnitType unitType, String unitTypeString, int minUnitCnt, int maxUnitCnt) {
        this.packageTypeName = packageTypeName;
        this.packageVolume = packageVolume;
        this.packageVolumeType = packageVolumeType;
        this.unitType = unitType;
        this.unitTypeString = unitTypeString;
        this.minUnitCnt = minUnitCnt;
        this.maxUnitCnt = maxUnitCnt;
    }
}
