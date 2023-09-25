package org.fish.product.modules.category.services;

import com.baomidou.mybatisplus.extension.service.IService;
import org.fish.product.modules.category.entity.CategoryEntity;

import java.util.List;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
public interface CategoryService extends IService<CategoryEntity> {
    void createCate(CategoryEntity entity);

    List<CategoryEntity> listWithTree();

    void delCate(List<Long> cateIds);
}