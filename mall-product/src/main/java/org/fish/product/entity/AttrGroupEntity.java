package org.fish.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 属性分组
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@TableName("pms_attr_group")
public class AttrGroupEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    @TableId(value = "attr_group_id", type = IdType.AUTO)
    private Long attrGroupId;

    /**
     * 组名
     */
    @TableField("attr_group_name")
    private String attrGroupName;

    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 描述
     */
    @TableField("`description`")
    private String description;

    /**
     * 组图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 所属分类id
     */
    @TableField("cate_log_id")
    private Long cateLogId;

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public String getAttrGroupName() {
        return attrGroupName;
    }

    public void setAttrGroupName(String attrGroupName) {
        this.attrGroupName = attrGroupName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCateLogId() {
        return cateLogId;
    }

    public void setCateLogId(Long cateLogId) {
        this.cateLogId = cateLogId;
    }

    @Override
    public String toString() {
        return "AttrGroupEntity{" +
            "attrGroupId = " + attrGroupId +
            ", attrGroupName = " + attrGroupName +
            ", sort = " + sort +
            ", description = " + description +
            ", icon = " + icon +
            ", cateLogId = " + cateLogId +
        "}";
    }
}
