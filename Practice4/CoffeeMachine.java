package Shapenko.Practice4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    private List<Drink> drinks;

    public CoffeeMachine() {
        drinks=new ArrayList<>();
    }

    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void buy(int pos,User user){
        if(pos>drinks.size()){
            System.out.println("Wrong drink number");
        }
        Drink drink=drinks.get(pos-1);
        if(user.getAccount().getMoney().doubleValue()<drink.getPrice().doubleValue()){
            System.out.println("Don't enough money");
        }
        user.getAccount().setMoney(new BigDecimal(
                user.getAccount().getMoney().doubleValue()-drink.getPrice().doubleValue()
        ));
        System.out.println("Thank you for visiting. The less on your acc  is "+user.getAccount().getMoney().intValue());
    }

    public void fill(User user, Scanner scanner){
        if(!user.getRole().equalsIgnoreCase("Admin")){
            System.out.println("You are not admin");
            return;
        }
        while (true) {
            System.out.println("Choose Drink ");
            for (int i = 0; i < drinks.size(); i++) {
                System.out.println(i + " - " + drinks.get(i).getName() + " . Quantity - " + drinks.get(i).getQuantity());
            }
            int dr = scanner.nextInt();
            System.out.println("Write quantity");
            int q = scanner.nextInt();
            drinks.get(dr).setQuantity(drinks.get(dr).getQuantity()+q);
            System.out.println("if you want to end , please input \"end\" and press enter, if not wite \"go\"");
            String s=scanner.nextLine();
            s=checkInput(s,scanner);
            if(s.equalsIgnoreCase("end")){
                break;
            }
        }

    }
    public void printAll(){
        for(int i=0;i<drinks.size();i++){
            StringBuilder sb=new StringBuilder();
            sb.append(i+1).append(" - ").append(drinks.get(i).getName())
                    .append(" - ").append(drinks.get(i).getComponents()).append(" - Price - ").append(drinks.get(i).getPrice());
            System.out.println(sb.toString());
        }
    }
    private static String checkInput(String text, Scanner sc){
        if(text.equalsIgnoreCase("")){
            text=sc.nextLine();
            return checkInput(text,sc);

        }
        return text;
    }
}
