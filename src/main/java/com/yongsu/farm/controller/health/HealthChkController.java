package com.yongsu.farm.controller.health;

import com.yongsu.farm.dto.api.ApiResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/01
 */
@RestController
@RequestMapping("/health")
public class HealthChkController {

    @GetMapping
    public ResponseEntity<ApiResult> healthChk(){
        return ApiResult.ok().createResponseEntity();
    }
}
