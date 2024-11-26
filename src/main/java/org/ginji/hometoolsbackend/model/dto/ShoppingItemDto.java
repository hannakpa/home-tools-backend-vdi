package org.ginji.hometoolsbackend.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ShoppingItemDto {
    @NotEmpty
    @Size(min = 3, max = 20)
    private String articleName;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String quantity;

    @Size(max = 120)
    private String comment;
}
