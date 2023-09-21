package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Byte showStatus) {
        this.showStatus = showStatus;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
            "brandId = " + brandId +
            ", name = " + name +
            ", logo = " + logo +
            ", description = " + description +
            ", showStatus = " + showStatus +
            ", firstLetter = " + firstLetter +
            ", sort = " + sort +
        "}";
    }
}
