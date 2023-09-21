package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Byte getSearchType() {
        return searchType;
    }

    public void setSearchType(Byte searchType) {
        this.searchType = searchType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getValueSelect() {
        return valueSelect;
    }

    public void setValueSelect(String valueSelect) {
        this.valueSelect = valueSelect;
    }

    public Byte getAttrType() {
        return attrType;
    }

    public void setAttrType(Byte attrType) {
        this.attrType = attrType;
    }

    public Byte getValueType() {
        return valueType;
    }

    public void setValueType(Byte valueType) {
        this.valueType = valueType;
    }

    public Long getEnable() {
        return enable;
    }

    public void setEnable(Long enable) {
        this.enable = enable;
    }

    public Long getCateLogId() {
        return cateLogId;
    }

    public void setCateLogId(Long cateLogId) {
        this.cateLogId = cateLogId;
    }

    public Byte getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(Byte showDesc) {
        this.showDesc = showDesc;
    }

    @Override
    public String toString() {
        return "AttrEntity{" +
            "attrId = " + attrId +
            ", attrName = " + attrName +
            ", searchType = " + searchType +
            ", icon = " + icon +
            ", valueSelect = " + valueSelect +
            ", attrType = " + attrType +
            ", valueType = " + valueType +
            ", enable = " + enable +
            ", cateLogId = " + cateLogId +
            ", showDesc = " + showDesc +
        "}";
    }
}
