package org.fish.product.modules.category.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 商品三级分类
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @TableId(value = "cat_id", type = IdType.AUTO)
    private Long catId;

    /**
     * 分类名称
     */
    @TableField("`name`")
    private String name;

    /**
     * 父分类id
     */
    @TableField("parent_cid")
    private Long parentCid;

    /**
     * 层级
     */
    @TableField("cat_level")
    private Integer catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    @TableField("show_status")
    private Byte showStatus;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 图标地址
     */
    @TableField("icon")
    private String icon;

    /**
     * 计量单位
     */
    @TableField("product_unit")
    private String productUnit;

    /**
     * 商品数量
     */
    @TableField("product_count")
    private Integer productCount;

    /**
     * 是否删除
     */
    @JsonIgnore
    @TableLogic(value = "0", delval = "1")
    @TableField("is_deleted")
    private Byte isDeleted;

    @TableField(exist = false)
    private List<CategoryEntity> children;
}
