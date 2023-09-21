package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * spu信息介绍
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "spu_id", type = IdType.NONE)
    private Long spuId;

    /**
     * 商品介绍
     */
    @TableField("description")
    private String description;
}
