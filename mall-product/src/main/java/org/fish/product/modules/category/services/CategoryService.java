package org.fish.product.modules.category.services;

import org.fish.product.modules.category.entity.CategoryEntity;
import com.baomidou.mybatisplus.extension.service.IService;

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
    List<CategoryEntity> listWithTree();
}