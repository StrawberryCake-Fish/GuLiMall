package org.fish.product.modules.category.controller;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.fish.core.http.CommonResult;
import org.fish.product.modules.category.body.DeleteRaw;
import org.fish.product.modules.category.entity.CategoryEntity;
import org.fish.product.modules.category.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品三级分类 前端控制器
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Slf4j
@Data
@RestController
@RequestMapping("/product/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/tree")
    public CommonResult<Object> tree() {
        List<CategoryEntity> entityList = categoryService.listWithTree();
        return CommonResult.ok(entityList);
    }

    @PostMapping(value = "/create")
    public CommonResult<Object> add() {
        return CommonResult.ok();
    }

    @PostMapping(value = "/info")
    public CommonResult<Object> info() {
        return CommonResult.ok();
    }

    @PostMapping(value = "/delete")
    public CommonResult<Object> remove(@Valid @RequestBody DeleteRaw deleteRaw) {
        categoryService.delCate(deleteRaw.getCateIds());
        return CommonResult.ok();
    }
}
