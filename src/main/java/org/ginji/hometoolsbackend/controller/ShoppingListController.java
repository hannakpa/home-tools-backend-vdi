package org.ginji.hometoolsbackend.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ginji.hometoolsbackend.model.dto.ShoppingListEntryDto;
import org.ginji.hometoolsbackend.service.ShoppingListService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/api/shoppingList")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @PostMapping("/create")
    public ResponseEntity<ShoppingListEntryDto> createShoppingList(
            @RequestBody ShoppingListEntryDto shoppingListEntryDto) {

        ShoppingListEntryDto savedShoppingListEntry;

        try {
            savedShoppingListEntry = this.shoppingListService.save(shoppingListEntryDto);
        } catch (DataIntegrityViolationException ex) {
            log.error("ERROR: " + ex.getCause());
            log.error("MESSAGE:" + ex.getMessage());

            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }

        return ResponseEntity.ok(savedShoppingListEntry);
    }

    @PostMapping("/edit")
    public ResponseEntity<ShoppingListEntryDto> editShoppingList(
            @RequestBody ShoppingListEntryDto shoppingListEntryDto
    ) {
        ShoppingListEntryDto shoppingListEntryToUpdate;

        try {
            shoppingListEntryToUpdate = this.shoppingListService.update(shoppingListEntryDto);
        } catch (EntityNotFoundException ex) {
            log.error("ERROR: " + ex.getCause());
            log.error("MESSAGE:" + ex.getMessage());

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }

        return ResponseEntity.ok(shoppingListEntryToUpdate);
    }

    @GetMapping()
    public ResponseEntity<List<ShoppingListEntryDto>> getAllShoppingListsForUser(
            @RequestParam String username) {

        List<ShoppingListEntryDto> shoppingLists = this.shoppingListService.getAllByUsername(username);

        return ResponseEntity.ok(shoppingLists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingListEntryDto> getShoppingListById(
            @PathVariable Long id
    ) {
        ShoppingListEntryDto shoppingListEntry;

        try {
            shoppingListEntry = this.shoppingListService.getShoppingListById(id);
        } catch (EntityNotFoundException ex) {
            log.error(ex.getMessage() + " " + ex.getMessage());

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }

        return ResponseEntity.ok(shoppingListEntry);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShoppingListById(
            @PathVariable Long id
    ) {
        try {
            this.shoppingListService.deleteById(id);
        } catch (EntityNotFoundException ex) {
            log.error(ex.getMessage() + " " + ex.getMessage());

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        } catch (DataIntegrityViolationException ex) {
            log.error(ex.getMessage() + " " + ex.getMessage());

            throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage(), ex);
        }

        return ResponseEntity.ok().build();
    }
}
