package org.fish.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fish.product.entity.ProductAttrValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * spu属性值 Mapper 接口
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Mapper
public interface ProductAttrValueMapper extends BaseMapper<ProductAttrValueEntity> {

}
