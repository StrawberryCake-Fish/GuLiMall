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
 * spu图片
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_spu_images")
public class SpuImagesEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu_id
     */
    @TableField("spu_id")
    private Long spuId;

    /**
     * 图片名
     */
    @TableField("img_name")
    private String imgName;

    /**
     * 图片地址
     */
    @TableField("img_url")
    private String imgUrl;

    /**
     * 顺序
     */
    @TableField("img_sort")
    private Integer imgSort;

    /**
     * 是否默认图
     */
    @TableField("default_img")
    private Byte defaultImg;
}
