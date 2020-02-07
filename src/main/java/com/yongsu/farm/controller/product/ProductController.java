package com.yongsu.farm.controller.product;

import com.yongsu.farm.dto.api.ApiResult;
import com.yongsu.farm.dto.api.Code;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.exception.BusinessException;
import com.yongsu.farm.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/02/05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/category-list")
    public ResponseEntity<ApiResult> getProductCategoryList(){

        final CodeResult codeResult = productService.getProductCategoryList();

        return codeResult.isSucceeded() ?
                ApiResult.ok(codeResult.getData()).createResponseEntity() :
                ApiResult.fail(codeResult.getCode(), codeResult.getMessage()).createResponseEntity();
    }

    @GetMapping
    public ResponseEntity test(){

        if(1 == 1) throw new BusinessException(Code.BAD_REQUEST,"크크크 테스트입니다.");

        return ApiResult.fail(Code.BAD_REQUEST).createResponseEntity();
    }

}
