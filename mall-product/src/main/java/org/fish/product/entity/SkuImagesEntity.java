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
 * sku图片
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_sku_images")
public class SkuImagesEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    @TableField("sku_id")
    private Long skuId;

    /**
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 排序
     */
    @TableField("img_sort")
    private Integer imgSort;

    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    @TableField("default_img")
    private Integer defaultImg;
}
