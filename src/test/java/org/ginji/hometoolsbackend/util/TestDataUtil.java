package org.ginji.hometoolsbackend.util;

import org.ginji.hometoolsbackend.model.dto.ShoppingItemDto;
import org.ginji.hometoolsbackend.model.dto.ShoppingListEntryDto;
import org.ginji.hometoolsbackend.model.entity.ShoppingItem;
import org.ginji.hometoolsbackend.model.entity.ShoppingListEntry;

import java.util.Date;
import java.util.List;

public class TestDataUtil {
    public static ShoppingItemDto createShoppingItemDto(String articleName, String quantity, String comment) {
        ShoppingItemDto shoppingItemDto = new ShoppingItemDto();
        shoppingItemDto.setArticleName(articleName);
        shoppingItemDto.setQuantity(quantity);
        shoppingItemDto.setComment(comment);
        return shoppingItemDto;
    }

    public static ShoppingItem createShoppingItem(String articleName, String quantity, String comment) {
        ShoppingItem shoppingItem = new ShoppingItem();
        shoppingItem.setArticleName(articleName);
        shoppingItem.setQuantity(quantity);
        shoppingItem.setComment(comment);
        return shoppingItem;
    }

    public static ShoppingListEntryDto createShoppingListEntryDto(Long id, String name, boolean finishedFlag, Date dueDate, List<String> entitledUsernames, List<ShoppingItemDto> shoppingItems) {
        ShoppingListEntryDto shoppingListEntryDto = new ShoppingListEntryDto();
        shoppingListEntryDto.setId(id);
        shoppingListEntryDto.setName(name);
        shoppingListEntryDto.setFinishedFlag(finishedFlag);
        shoppingListEntryDto.setDueDate(dueDate);
        shoppingListEntryDto.setEntitledUsernames(entitledUsernames);
        shoppingListEntryDto.setShoppingItems(shoppingItems);
        return shoppingListEntryDto;
    }

    public static ShoppingListEntry createShoppingListEntry(Long id, String name, boolean finishedFlag, Date dueDate, List<String> entitledUsernames, List<ShoppingItem> shoppingItems) {
        ShoppingListEntry shoppingListEntry = new ShoppingListEntry();
        shoppingListEntry.setId(id);
        shoppingListEntry.setName(name);
        shoppingListEntry.setFinishedFlag(finishedFlag);
        shoppingListEntry.setDueDate(dueDate);
        shoppingListEntry.setEntitledUsernames(entitledUsernames);
        shoppingListEntry.setShoppingItems(shoppingItems);
        return shoppingListEntry;
    }
}
