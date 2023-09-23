package org.fish.product.modules.category.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fish.product.modules.category.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品三级分类 Mapper 接口
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

}
