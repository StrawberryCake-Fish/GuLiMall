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
 * 商品属性
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    @TableId(value = "attr_id", type = IdType.AUTO)
    private Long attrId;

    /**
     * 属性名
     */
    @TableField("attr_name")
    private String attrName;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @TableField("search_type")
    private Byte searchType;

    /**
     * 属性图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 可选值列表[用逗号分隔]
     */
    @TableField("value_select")
    private String valueSelect;

    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    @TableField("attr_type")
    private Byte attrType;

    @TableField("value_type")
    private Byte valueType;

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @TableField("`enable`")
    private Long enable;

    /**
     * 所属分类
     */
    @TableField("cate_log_id")
    private Long cateLogId;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @TableField("show_desc")
    private Byte showDesc;
}
