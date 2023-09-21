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
 * 品牌
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Long brandId;

    /**
     * 品牌名
     */
    @TableField("`name`")
    private String name;

    /**
     * 品牌logo地址
     */
    @TableField("logo")
    private String logo;

    /**
     * 介绍
     */
    @TableField("`description`")
    private String description;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    @TableField("show_status")
    private Byte showStatus;

    /**
     * 检索首字母
     */
    @TableField("first_letter")
    private String firstLetter;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;
}
