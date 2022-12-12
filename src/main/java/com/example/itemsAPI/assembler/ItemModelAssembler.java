package com.example.itemsAPI.assembler;

import com.example.itemsAPI.controller.ItemController;
import com.example.itemsAPI.repository.entity.Item;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component //converts the an Item object to a model-based object- in order to include links
public class ItemModelAssembler implements RepresentationModelAssembler<Item, EntityModel<Item>> {

    @Override
    public EntityModel<Item> toModel(Item item){
        return EntityModel.of(item,
                linkTo(methodOn(ItemController.class).findItemById(item.getId())).withSelfRel(),
                linkTo(methodOn(ItemController.class).getItems()).withRel("employees"));
    }
}
