package org.ginji.hometoolsbackend.repository;

import org.ginji.hometoolsbackend.model.entity.ShoppingListEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingListEntry, Long> {
    List<ShoppingListEntry> findAllByEntitledUsernamesContaining(String username);
}
