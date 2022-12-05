package com.bookstore.model;

import com.bookstore.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart(){
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }

    public Item getItemById(int id){
        for(Item i : items){
            if(i.getProduct().getId() == id){
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t){
        if(getItemById(t.getProduct().getId()) != null){
            Item m = getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        }
        else{
            items.add(t);
        }
    }

    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }

    public int getTotalMoney() {
        int total = 0;
        for (Item i : items) {
            total += (i.getPrice() * i.getQuantity());
        }
        return total;
    }
}
