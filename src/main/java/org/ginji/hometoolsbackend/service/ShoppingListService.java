package org.ginji.hometoolsbackend.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.ginji.hometoolsbackend.model.dto.ShoppingListEntryDto;
import org.ginji.hometoolsbackend.model.entity.ShoppingListEntry;
import org.ginji.hometoolsbackend.repository.ShoppingListRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    private final ModelMapper modelMapper;

    public ShoppingListEntryDto save(ShoppingListEntryDto shoppingListEntryDto) throws DataIntegrityViolationException {
        ShoppingListEntry shoppingListEntry = modelMapper.map(shoppingListEntryDto, ShoppingListEntry.class);
        shoppingListEntry.setCreationDate(new Date());

        shoppingListEntry = shoppingListRepository.save(shoppingListEntry);

        return modelMapper.map(shoppingListEntry, ShoppingListEntryDto.class);
    }

    public ShoppingListEntryDto update(ShoppingListEntryDto shoppingListEntryDto) throws DataIntegrityViolationException {
        ShoppingListEntry shoppingListEntry = modelMapper.map(shoppingListEntryDto, ShoppingListEntry.class);
        shoppingListEntry = shoppingListRepository.save(shoppingListEntry);

        return modelMapper.map(shoppingListEntry, ShoppingListEntryDto.class);
    }


    public List<ShoppingListEntryDto> getAllByUsername(String username) {
        List<ShoppingListEntry> shoppingListEntries = shoppingListRepository.findAllByEntitledUsernamesContaining(username);

        return modelMapper.map(shoppingListEntries, new TypeToken<List<ShoppingListEntryDto>>() {
        }.getType());
    }

    public ShoppingListEntryDto getShoppingListById(Long id) {
        Optional<ShoppingListEntry> shoppingListEntryOptional = shoppingListRepository.findById(id);

        if (shoppingListEntryOptional.isPresent()) {
            return modelMapper.map(shoppingListEntryOptional.get(), ShoppingListEntryDto.class);
        } else {
            throw new EntityNotFoundException("Die Einkaufsliste mit der Id " + id + " wurde nicht gefunden");
        }
    }

    public void deleteById(Long id) {
        try {
            this.shoppingListRepository.deleteById(id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("Die Einkaufsliste mit der id " + id + " existiert nicht");
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Fehler beim löschen der Einkaufsliste mit der id " + id);
        }
    }
}
