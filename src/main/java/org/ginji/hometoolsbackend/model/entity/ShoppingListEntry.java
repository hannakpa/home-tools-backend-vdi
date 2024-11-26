package org.ginji.hometoolsbackend.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shopping_list")
@Data
public class ShoppingListEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date creationDate;

    private Date dueDate;

    private Boolean finishedFlag;

    @ElementCollection
    @CollectionTable(
            name = "shopping_list_entitled_users",
            joinColumns = @JoinColumn(name = "shopping_list_id", referencedColumnName = "id")
    )
    private List<String> entitledUsernames;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<ShoppingItem> shoppingItems;
}
