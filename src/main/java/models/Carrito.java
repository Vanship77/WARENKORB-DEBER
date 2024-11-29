package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrito {
    private List<ItemsCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    // Método para agregar un artículo al carrito
    public void addItemsCarrito(ItemsCarrito itemCarro) {
        // Verificamos si el artículo ya está en el carrito
        Optional<ItemsCarrito> optionalItemCarro = items.stream()
                .filter(i -> i.equals(itemCarro))
                .findAny();

        // Si el artículo ya existe, incrementamos su cantidad
        if (optionalItemCarro.isPresent()) {
            ItemsCarrito existingItem = optionalItemCarro.get();
            existingItem.setCantidad(existingItem.getCantidad() + 1);
        } else {
            // Si el artículo no existe, lo añadimos al carrito
            this.items.add(itemCarro);
        }
    }

    // Método para obtener la lista de artículos en el carrito
    public List<ItemsCarrito> getItems() {
        return items;
    }

    // Método para calcular el total del carrito
    public double getTotal() {
        return items.stream().mapToDouble(ItemsCarrito::getSubtotal).sum(); // Cambiado a getSubtotal
    }
}