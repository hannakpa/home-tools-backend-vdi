package org.ginji.hometoolsbackend.service;

import jakarta.persistence.EntityNotFoundException;
import org.ginji.hometoolsbackend.model.dto.ShoppingItemDto;
import org.ginji.hometoolsbackend.model.dto.ShoppingListEntryDto;
import org.ginji.hometoolsbackend.model.entity.ShoppingItem;
import org.ginji.hometoolsbackend.model.entity.ShoppingListEntry;
import org.ginji.hometoolsbackend.repository.ShoppingListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.ginji.hometoolsbackend.util.TestDataUtil.*;
import static org.mockito.Mockito.when;

// -------------------------------------------------------- //
// ------- Load only the needed application context ------- //
// -------------------------------------------------------- //
@ExtendWith(MockitoExtension.class)
class BestPracticesUnitTest {

    // ----------------------------------------------- //
    // ------- Should test only one Class/Unit ------- //
    // ----------------------------------------------- //
    @InjectMocks
    private ShoppingListService shoppingListService;

    // -------------------------------------------- //
    // ------- Should mock all dependencies ------- //
    // -------------------------------------------- //
    @Mock
    private ShoppingListRepository mockShoppingListRepository;

    @Mock
    private ModelMapper mockModulMapper;

    // ------------------------------------------------------------------------------- //
    // ------- Should fail at least once to test everything is setup correctly ------- //
    // ------------------------------------------------------------------------------- //
    @Test
    void shouldFailAtLeastOnce() {
        assertThat(true).isEqualTo(false);
    }

    // -------------------------------------------------------- //
    // ------- Use the 3 A rule to structure your tests ------- //
    // -------------------------------------------------------- //
    @Test
    void shouldUseThe3ARuleForStructure() {
        // ARRANGE
        // Prepare your test-data and mocks

        // ACT
        // Call the "System under Test"

        // ASSERT
        // Check if everything works correctly
    }

    // --------------------------------------------------------------------------------------------- //
    // ------- Create a test data constructor or utility classes to keep your tests readable ------- //
    // --------------------------------------------------------------------------------------------- //
    @Test
    void shouldBeReadableButIsNot() {
        // ARRANGE
        List<String> testEntiteledUsernameList = List.of(
                "Utz",
                "Andre"
        );

        ShoppingItemDto testShoppingItemDto1 = new ShoppingItemDto();
        testShoppingItemDto1.setArticleName("Brot");
        testShoppingItemDto1.setQuantity("1 Leib");
        testShoppingItemDto1.setComment("Vom guten Bäcker");

        ShoppingItemDto testShoppingItemDto2 = new ShoppingItemDto();
        testShoppingItemDto2.setArticleName("Käse");
        testShoppingItemDto2.setQuantity("1 Packung");
        testShoppingItemDto2.setComment("Scheibenkäse, kein ganzer");

        ShoppingItem testShoppingItem1 = new ShoppingItem();
        testShoppingItem1.setArticleName("Brot");
        testShoppingItem1.setQuantity("1 Leib");
        testShoppingItem1.setComment("Vom guten Bäcker");

        ShoppingItem testShoppingItem2 = new ShoppingItem();
        testShoppingItem2.setArticleName("Käse");
        testShoppingItem2.setQuantity("1 Packung");
        testShoppingItem2.setComment("Scheibenkäse, kein ganzer");

        List<ShoppingItemDto> testShoppingListItemDtoList = List.of(
                testShoppingItemDto1,
                testShoppingItemDto2
        );

        List<ShoppingItem> testShoppingListItemList = List.of(
                testShoppingItem1,
                testShoppingItem2
        );

        ShoppingListEntryDto testShoppingListEntryDto = new ShoppingListEntryDto();
        testShoppingListEntryDto.setName("Shopping List for Today");
        testShoppingListEntryDto.setFinishedFlag(true);
        testShoppingListEntryDto.setDueDate(new Date());
        testShoppingListEntryDto.setEntitledUsernames(testEntiteledUsernameList);
        testShoppingListEntryDto.setShoppingItems(testShoppingListItemDtoList);

        ShoppingListEntry testShoppingListEntry = new ShoppingListEntry();
        testShoppingListEntry.setId(1L);
        testShoppingListEntry.setName("Shopping List for Today");
        testShoppingListEntry.setFinishedFlag(true);
        testShoppingListEntry.setDueDate(new Date());
        testShoppingListEntry.setEntitledUsernames(testEntiteledUsernameList);
        testShoppingListEntry.setShoppingItems(testShoppingListItemList);

        when(mockShoppingListRepository.findById(1L)).thenReturn(Optional.of(testShoppingListEntry));
        when(mockModulMapper.map(testShoppingListEntry, ShoppingListEntryDto.class)).thenReturn(testShoppingListEntryDto);

        // ACT
        ShoppingListEntryDto actualResult = shoppingListService.getShoppingListById(1L);

        // ASSERT
        assertThat(actualResult).isEqualTo(testShoppingListEntryDto);
    }

    @Test
    void shouldBeReadableAndItIs() {
        // ARRANGE
        ShoppingItemDto breadItemDto = createShoppingItemDto("Brot", "1 Leib", "Vom guten Bäcker");
        ShoppingItemDto cheeseItemDto = createShoppingItemDto("Käse", "1 Packung", "Scheibenkäse, kein ganzer");

        List<ShoppingItemDto> shoppingItemDtos = List.of(breadItemDto, cheeseItemDto);

        ShoppingItem breadItem = createShoppingItem("Brot", "1 Leib", "Vom guten Bäcker");
        ShoppingItem cheeseItem = createShoppingItem("Käse", "1 Packung", "Scheibenkäse, kein ganzer");

        List<ShoppingItem> shoppingItems = List.of(breadItem, cheeseItem);
        List<String> entitledUsernames = List.of("Utz", "Andre");

        ShoppingListEntryDto testShoppingListEntryDto = createShoppingListEntryDto(1L, "Shopping List for Today", true, new Date(), entitledUsernames, shoppingItemDtos);

        // Setup ShoppingListEntry (domain object)
        ShoppingListEntry testShoppingListEntry = createShoppingListEntry(1L, "Shopping List for Today", true, new Date(), entitledUsernames, shoppingItems);

        when(mockShoppingListRepository.findById(1L)).thenReturn(Optional.of(testShoppingListEntry));
        when(mockModulMapper.map(testShoppingListEntry, ShoppingListEntryDto.class)).thenReturn(testShoppingListEntryDto);

        // ACT
        ShoppingListEntryDto actualResult = shoppingListService.getShoppingListById(1L);

        // ASSERT
        assertThat(actualResult).isEqualTo(testShoppingListEntryDto);
    }

    // -------------------------------------------------- //
    // ------- Test all paths of a method, BUT... ------- //
    // -------------------------------------------------- //
    @Test
    void shouldTestAllPathsButDoNotDoThis() {
        // ARRANGE
        ShoppingItemDto breadItemDto = createShoppingItemDto("Brot", "1 Leib", "Vom guten Bäcker");
        ShoppingItemDto cheeseItemDto = createShoppingItemDto("Käse", "1 Packung", "Scheibenkäse, kein ganzer");

        List<ShoppingItemDto> shoppingItemDtos = List.of(breadItemDto, cheeseItemDto);

        ShoppingItem breadItem = createShoppingItem("Brot", "1 Leib", "Vom guten Bäcker");
        ShoppingItem cheeseItem = createShoppingItem("Käse", "1 Packung", "Scheibenkäse, kein ganzer");

        List<ShoppingItem> shoppingItems = List.of(breadItem, cheeseItem);
        List<String> entitledUsernames = List.of("Utz", "Andre");

        ShoppingListEntryDto testShoppingListEntryDto = createShoppingListEntryDto(1L,"Shopping List for Today", true, new Date(), entitledUsernames, shoppingItemDtos);

        // Setup ShoppingListEntry (domain object)
        ShoppingListEntry testShoppingListEntry = createShoppingListEntry(1L, "Shopping List for Today", true, new Date(), entitledUsernames, shoppingItems);

        when(mockShoppingListRepository.findById(1L)).thenReturn(Optional.of(testShoppingListEntry));
        when(mockModulMapper.map(testShoppingListEntry, ShoppingListEntryDto.class)).thenReturn(testShoppingListEntryDto);

        // ACT 1
        ShoppingListEntryDto actualResult = shoppingListService.getShoppingListById(1L);

        // ASSERT 1
        assertThat(actualResult).isEqualTo(testShoppingListEntryDto);

        // ARRANGE 2
        when(mockShoppingListRepository.findById(1L)).thenReturn(Optional.empty());

        // ACT 2 // ASSERT 2
        assertThatThrownBy(() -> {
            shoppingListService.getShoppingListById(1L);
        }).isInstanceOf(EntityNotFoundException.class).hasMessage("Die Einkaufsliste mit der Id 1 wurde nicht gefunden");
    }

    // --------------------------------------------------- //
    // ------- ...only use one assert per testcase ------- //
    // --------------------------------------------------- //

    @Test
    void shouldReturnTheCorrectObjectOnCorrectRepositoryResponse() {
        // ARRANGE
        ShoppingItemDto breadItemDto = createShoppingItemDto("Brot", "1 Leib", "Vom guten Bäcker");
        ShoppingItemDto cheeseItemDto = createShoppingItemDto("Käse", "1 Packung", "Scheibenkäse, kein ganzer");

        List<ShoppingItemDto> shoppingItemDtos = List.of(breadItemDto, cheeseItemDto);

        ShoppingItem breadItem = createShoppingItem("Brot", "1 Leib", "Vom guten Bäcker");
        ShoppingItem cheeseItem = createShoppingItem("Käse", "1 Packung", "Scheibenkäse, kein ganzer");

        List<ShoppingItem> shoppingItems = List.of(breadItem, cheeseItem);
        List<String> entitledUsernames = List.of("Utz", "Andre");

        ShoppingListEntryDto testShoppingListEntryDto = createShoppingListEntryDto(1L,"Shopping List for Today", true, new Date(), entitledUsernames, shoppingItemDtos);
        ShoppingListEntry testShoppingListEntry = createShoppingListEntry(1L, "Shopping List for Today", true, new Date(), entitledUsernames, shoppingItems);

        when(mockShoppingListRepository.findById(1L)).thenReturn(Optional.of(testShoppingListEntry));
        when(mockModulMapper.map(testShoppingListEntry, ShoppingListEntryDto.class)).thenReturn(testShoppingListEntryDto);

        // ACT
        ShoppingListEntryDto actualResult = shoppingListService.getShoppingListById(1L);

        // ASSERT
        assertThat(actualResult).isEqualTo(testShoppingListEntryDto);
    }

    @Test
    void shouldThrowEntityNotFoundErrorOnNotFoundRepositoryResponse() {
        // ARRANGE
        when(mockShoppingListRepository.findById(1L)).thenReturn(Optional.empty());

        // ACT // ASSERT
        assertThatThrownBy(() -> {
            shoppingListService.getShoppingListById(1L);
        }).isInstanceOf(EntityNotFoundException.class).hasMessage("Die Einkaufsliste mit der Id 1 wurde nicht gefunden");
    }
}
