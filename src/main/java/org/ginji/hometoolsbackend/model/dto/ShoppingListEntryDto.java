package org.ginji.hometoolsbackend.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class ShoppingListEntryDto {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 60)
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date dueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date creationDate;

    @NotNull
    private Boolean finishedFlag;

    @NotEmpty
    private List<String> entitledUsernames;

    @NotEmpty
    private List<ShoppingItemDto> shoppingItems;

}
