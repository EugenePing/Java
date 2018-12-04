package Shapenko.Practice4;

import java.math.BigDecimal;

public class Account {
    private BigDecimal money;
    private String id;

    public Account(BigDecimal money, String id) {
        this.money = money;
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
