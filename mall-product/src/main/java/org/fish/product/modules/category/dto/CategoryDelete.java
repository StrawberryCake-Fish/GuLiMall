package org.fish.product.modules.category.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDelete {
    @NotEmpty
    private List<Long> cateIds;
}
