package org.ginji.hometoolsbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.ginji.hometoolsbackend.model.dto.ShoppingItemDto;
import org.ginji.hometoolsbackend.model.dto.ShoppingListEntryDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.ginji.hometoolsbackend.util.TestDataUtil.createShoppingItemDto;
import static org.ginji.hometoolsbackend.util.TestDataUtil.createShoppingListEntryDto;

// ------------------------------------------------- //
// ------- Load the full application context ------- //
// ------------------------------------------------- //
@SpringBootTest
@Transactional
class ServiceRepositoryIntegrationTest {

    // --------------------------------------------------------------------------------- //
    // ------- Here we integrate the service and the database (repository) layer ------- //
    // --------------------------------------------------------------------------------- //

    @Autowired
    private ShoppingListService shoppingListService;

    // --------------------------------------------------------------------------- //
    // ------- Use no mocking to test the integration between to units... -------- //
    // ----------- ...But mock external dependencies like the database ----------- //
    // --------------------------------------------------------------------------- //

    @Test
    void shouldReturnTheCorrectObjectOnFoundDatabaseEntry() {
        // ARRANGE
        ShoppingItemDto breadItemDto = createShoppingItemDto("Brot", "1 Leib", "Vom guten Baecker");
        ShoppingItemDto cheeseItemDto = createShoppingItemDto("Kaese", "1 Packung", "Scheibenkaese, kein ganzer");

        List<ShoppingItemDto> shoppingItemDtos = List.of(breadItemDto, cheeseItemDto);

        List<String> entitledUsernames = List.of("utz123", "andre123");

        ShoppingListEntryDto testShoppingListEntryDto = createShoppingListEntryDto(124L, "Shopping List for Today", true, null, entitledUsernames, shoppingItemDtos);

        // ACT
        ShoppingListEntryDto actualResult = shoppingListService.getShoppingListById(124L);

        // ASSERT
        assertThat(actualResult).isEqualTo(testShoppingListEntryDto);
    }

    @Test
    void shouldThrowEntityNotFoundErrorOnNotFoundDatabaseEntry() {
        // ARRANGE

        // ACT // ASSERT
        assertThatThrownBy(() -> {
            shoppingListService.getShoppingListById(1L);
        }).isInstanceOf(EntityNotFoundException.class).hasMessage("Die Einkaufsliste mit der Id 1 wurde nicht gefunden");
    }
}
