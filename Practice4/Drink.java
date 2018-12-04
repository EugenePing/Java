package Shapenko.Practice4;

import java.math.BigDecimal;
import java.util.List;

public interface Drink {
    String getName();
    BigDecimal getPrice();
    List<String> getComponents();
    int getQuantity();
    void make();
    void setQuantity(int quantity);
}
