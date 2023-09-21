package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
    @TableField("decript")
    private String decript;

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getDecript() {
        return decript;
    }

    public void setDecript(String decript) {
        this.decript = decript;
    }

    @Override
    public String toString() {
        return "SpuInfoDescEntity{" +
            "spuId = " + spuId +
            ", decript = " + decript +
        "}";
    }
}
