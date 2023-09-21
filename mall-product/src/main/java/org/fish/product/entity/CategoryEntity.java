package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 商品三级分类
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
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

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentCid() {
        return parentCid;
    }

    public void setParentCid(Long parentCid) {
        this.parentCid = parentCid;
    }

    public Integer getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(Integer catLevel) {
        this.catLevel = catLevel;
    }

    public Byte getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Byte showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
            "catId = " + catId +
            ", name = " + name +
            ", parentCid = " + parentCid +
            ", catLevel = " + catLevel +
            ", showStatus = " + showStatus +
            ", sort = " + sort +
            ", icon = " + icon +
            ", productUnit = " + productUnit +
            ", productCount = " + productCount +
        "}";
    }
}
