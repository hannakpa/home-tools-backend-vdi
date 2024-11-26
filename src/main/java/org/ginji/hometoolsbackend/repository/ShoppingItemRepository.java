package org.ginji.hometoolsbackend.repository;

import org.ginji.hometoolsbackend.model.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {
}
