package org.fish.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.fish.core.http.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 品牌 前端控制器
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Slf4j
@RestController
@RequestMapping("/product/brand")
public class BrandController {
    @GetMapping(value = "/list")
    public CommonResult<Object> Test() {
        log.info("==================> Test");
        return CommonResult.ok();
    }
}
