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
 * 属性分组
 * </p>
 *
 * @author Fish
 * @since 2023-09-22
 */
@Data
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
}
