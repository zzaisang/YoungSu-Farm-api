package com.yongsu.farm.mapper.policy;

import com.yongsu.farm.domain.policy.PackagePolicy;
import com.yongsu.farm.dto.policy.PackagePolicyDto;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/03/14
 */
public class PackagePolicyMapper {
    private PackagePolicyMapper() {
    }

    public static PackagePolicyDto makePackagePolicyDto(PackagePolicy packagePolicy){
        return PackagePolicyDto.builder()
                .packageTypeName(packagePolicy.getPackageType().getName())
                .packageVolume(packagePolicy.getPackageVolume())
                .packageVolumeType(packagePolicy.getPackageVolumeType())
                .unitType(packagePolicy.getUnitType())
                .unitTypeString(packagePolicy.getUnitType().getName())
                .minUnitCnt(packagePolicy.getMinUnitCnt())
                .maxUnitCnt(packagePolicy.getMaxUnitCnt())
                .build();
    }
}
