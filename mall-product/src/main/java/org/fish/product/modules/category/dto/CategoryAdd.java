package org.fish.product.modules.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryAdd {
    @NotBlank
    private String name;

    @NotNull
    private Long parentCid;

    @NotNull
    private Integer catLevel;

    private Integer sort;

    private String icon;

    private String productUnit;

    private Integer productCount;
}
