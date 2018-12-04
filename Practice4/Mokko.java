package Shapenko.Practice4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Mokko implements Drink {
    private String name;
    private BigDecimal price;
    private List<String> components;
    private int quantity;

    public Mokko() {
        name="Mokko";
        price=new BigDecimal(80);
        components=new ArrayList<>();
        components.add("Sugar");
        components.add("cream");
        quantity=3;
    }

    @Override
    public void make() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getComponents() {
        return components;
    }

    public void addComponent(String comp) {
        components.add("Component");

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
