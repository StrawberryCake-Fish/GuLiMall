package org.fish.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.fish.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品评价回复关系 Mapper 接口
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Mapper
public interface CommentReplayMapper extends BaseMapper<CommentReplayEntity> {

}
