package com.yongsu.farm.controller.product;

import com.yongsu.farm.dto.api.ApiResult;
import com.yongsu.farm.dto.api.CodeResult;
import com.yongsu.farm.service.product.ProductCategoryService;
import com.yongsu.farm.service.product.RecommendedProductService;
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

    private final ProductCategoryService productCategoryService;
    private final RecommendedProductService recommendedProductService;

    @GetMapping("/category-list")
    public ResponseEntity<ApiResult> getProductCategoryList(){

        final CodeResult codeResult = productCategoryService.getProductCategoryList();

        return codeResult.isSucceeded() ?
                ApiResult.ok(codeResult.getData()).createResponseEntity() :
                ApiResult.fail(codeResult.getCode(), codeResult.getMessage()).createResponseEntity();
    }

    @GetMapping("/recommend")
    public ResponseEntity<ApiResult> getRecommendList(){

        final CodeResult codeResult = recommendedProductService.getRecommendList();

        return codeResult.isSucceeded() ?
                ApiResult.ok(codeResult.getData()).createResponseEntity() :
                ApiResult.fail(codeResult.getCode(), codeResult.getMessage()).createResponseEntity();
    }

}
