package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 属性&属性分组关联
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@TableName("pms_attr_attr_group_relation")
public class AttrAttrGroupRelationEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 属性id
     */
    @TableField("attr_id")
    private Long attrId;

    /**
     * 属性分组id
     */
    @TableField("attr_group_id")
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    @TableField("attr_sort")
    private Integer attrSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public Integer getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(Integer attrSort) {
        this.attrSort = attrSort;
    }

    @Override
    public String toString() {
        return "AttrAttrGroupRelationEntity{" +
            "id = " + id +
            ", attrId = " + attrId +
            ", attrGroupId = " + attrGroupId +
            ", attrSort = " + attrSort +
        "}";
    }
}
