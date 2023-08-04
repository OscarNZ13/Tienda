package com.Tienda.service;

import java.util.ArrayList;
import java.util.List;

import com.Tienda.entities.Item;

public interface IItemService {

    // en lugar de una tabla de DB se usa una arraylist para el registro temporal
    public List<Item> ListItems = new ArrayList<>();

    public List<Item> getItems();

    public void save(Item item);

    public void delete(Item item);

    public Item getItem(Item item);

    public void actualiza(Item item);

    public void facturar();
}
