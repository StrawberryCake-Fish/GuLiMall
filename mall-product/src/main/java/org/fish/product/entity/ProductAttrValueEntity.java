package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * spu属性值
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    @TableField("spu_id")
    private Long spuId;

    /**
     * 属性id
     */
    @TableField("attr_id")
    private Long attrId;

    /**
     * 属性名
     */
    @TableField("attr_name")
    private String attrName;

    /**
     * 属性值
     */
    @TableField("attr_value")
    private String attrValue;

    /**
     * 顺序
     */
    @TableField("attr_sort")
    private Integer attrSort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @TableField("quick_show")
    private Byte quickShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

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

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Integer getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(Integer attrSort) {
        this.attrSort = attrSort;
    }

    public Byte getQuickShow() {
        return quickShow;
    }

    public void setQuickShow(Byte quickShow) {
        this.quickShow = quickShow;
    }

    @Override
    public String toString() {
        return "ProductAttrValueEntity{" +
            "id = " + id +
            ", spuId = " + spuId +
            ", attrId = " + attrId +
            ", attrName = " + attrName +
            ", attrValue = " + attrValue +
            ", attrSort = " + attrSort +
            ", quickShow = " + quickShow +
        "}";
    }
}
