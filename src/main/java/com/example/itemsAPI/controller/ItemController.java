package com.example.itemsAPI.controller;

import com.example.itemsAPI.assembler.ItemModelAssembler;
import com.example.itemsAPI.controller.dto.ItemDto;
import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.service.ItemService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/item")
public class ItemController {

private final ItemRepository itemRepository;
private final ItemService itemService;

private final ItemModelAssembler assembler;

public ItemController(ItemRepository itemRepository, ItemService itemService, ItemModelAssembler assembler){
    this.itemRepository=itemRepository;
    this.assembler=assembler;
    this.itemService=itemService;
}


//    @GetMapping("/all")
//    public Iterable<Item> getItems(){
//        return itemService.all();
//    }
    @CrossOrigin
    @GetMapping("/all")
    public CollectionModel<EntityModel<Item>> getItems(){
        List<EntityModel<Item>> items=itemService.all().stream()
                .map(assembler::toModel).collect(Collectors.toList());

        return CollectionModel.of(items,
                linkTo(methodOn(ItemController.class).getItems()).withSelfRel());
    }

//    @PostMapping()
//    public Item addItem(@RequestBody ItemDto item ){
//
//        Item newItem=new Item(item);
//        return itemService.save(newItem);
//    }

    @CrossOrigin
    @PostMapping()
    public ResponseEntity<?> addItem(@RequestBody Item item){
    EntityModel<Item> itemModel=assembler.toModel(itemService.save(item));
    return ResponseEntity //used to create an created status http message
            .created(itemModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
            .body(itemModel);
    }

//    @GetMapping("/{id}")
//    public Item findItemById(@PathVariable Integer id){return itemService.findById(id);}

    @CrossOrigin
    @GetMapping("/{id}")
    public EntityModel<Item> findItemById(@PathVariable Integer id){
    Item item=itemService.findById(id);
    return assembler.toModel(item);
    }

//    @PutMapping( "/{id}" )
//    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
//    {
//        Item item = itemService.findById( id );
//        item.setName( itemDto.getName() );
//        item.setDescription( itemDto.getDescription() );
//        item.setImageURL( itemDto.getImageURL() );
//        item.setPrice(itemDto.getPrice());
//        item.setQuantity(itemDto.getQuantity());
//        return itemService.save( item );
//    }


    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ItemDto itemDto, @PathVariable Integer id){
    Item updateItem=itemService.findById(id);
        updateItem.setName(itemDto.getName());
        updateItem.setDescription(itemDto.getDescription());
        updateItem.setPrice(itemDto.getPrice());
        updateItem.setImageURL(itemDto.getImageURL());
        updateItem.setQuantity(itemDto.getQuantity());
       itemService.save(updateItem);


    EntityModel<Item> itemModel=assembler.toModel(updateItem);
    return ResponseEntity.created(itemModel.getRequiredLink(IanaLinkRelations.SELF)
            .toUri()).body(itemModel);

    }

//    @DeleteMapping( "/{id}" )
//    public void delete( @PathVariable Integer id )
//    {
//        itemService.delete( id );
//    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
    itemService.delete(id);
    return ResponseEntity.noContent().build();
    }

}
