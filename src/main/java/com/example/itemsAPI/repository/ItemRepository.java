package com.example.itemsAPI.repository;

import com.example.itemsAPI.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //accesses the database!
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
