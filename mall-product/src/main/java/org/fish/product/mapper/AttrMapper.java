package org.fish.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fish.product.entity.AttrEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品属性 Mapper 接口
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Mapper
public interface AttrMapper extends BaseMapper<AttrEntity> {

}
