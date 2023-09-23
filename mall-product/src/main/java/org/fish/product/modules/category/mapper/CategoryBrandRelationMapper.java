package org.fish.product.modules.category.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fish.product.modules.category.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 品牌分类关联 Mapper 接口
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Mapper
public interface CategoryBrandRelationMapper extends BaseMapper<CategoryBrandRelationEntity> {

}
