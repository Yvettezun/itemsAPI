package com.example.itemsAPI.service;

import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //represents model layer from mvc-provides methods to interact with database!
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }


    public Item save( Item item )
    {
       return this.itemRepository.save(item);


    }


    public void delete( int itemId )
    {
       Optional<Item> itemToDelete=this.itemRepository.findById(itemId);
       Item deleteItem=itemToDelete.get();
       this.itemRepository.delete(deleteItem);
    }


    public List<Item> all()
    {
        return this.itemRepository.findAll();
    }


    public Item findById( int itemId )
    {
         Optional<Item> item= this.itemRepository.findById(itemId);

         if(!item.isPresent()){
             return null;
         }

         Item itemFound=item.get();
         return itemFound;

    }

}
