package org.ginji.hometoolsbackend.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shopping_item")
@Data
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String articleName;

    private String quantity;

    private String comment;
}
