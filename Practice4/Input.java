package Shapenko.Practice4;

import java.math.BigDecimal;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine=new CoffeeMachine();
        coffeeMachine.addDrink(new Latte());
        coffeeMachine.addDrink(new Mokko());

        while (true) {

            System.out.println("1 - As admin\n2- As user\n 3- End");
            Scanner sc = new Scanner(System.in);
            String temp = sc.nextLine();
            temp = checkInput(temp, sc);
            switch (temp) {
                case "1": {
                    User user=new User("Admin",new Account(new BigDecimal(1),"t"));
                    coffeeMachine.fill(user,sc);
                    break;
                }
                case "2":{
                    User user=new User("User",new Account(new BigDecimal(1000),"11"));
                    System.out.println("On your acc 1000 dollars");
                    while (true){
                        System.out.println("Make decision");
                        coffeeMachine.printAll();
                        temp=sc.nextLine();
                        temp=checkInput(temp,sc);
                        coffeeMachine.buy(Integer.valueOf(temp),user);
                        System.out.println("If you want to logout please write \"end\", else write \"no\"");
                        temp=sc.nextLine();
                        temp=checkInput(temp,sc);
                        if(temp.equalsIgnoreCase("end")){
                            break;
                        }
                    }
                }
                case "3":{
                    System.exit(0);
                }
            }
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
