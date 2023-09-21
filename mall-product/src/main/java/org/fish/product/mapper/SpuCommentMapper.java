package org.fish.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fish.product.entity.SpuCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品评价 Mapper 接口
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Mapper
public interface SpuCommentMapper extends BaseMapper<SpuCommentEntity> {

}
