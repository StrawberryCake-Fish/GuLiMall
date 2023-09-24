package org.fish.product.modules.category.body;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class DeleteRaw {
    @NotEmpty(message = "cateIds can not be empty!")
    private List<Long> cateIds;
}
