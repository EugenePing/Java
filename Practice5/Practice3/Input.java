package Shapenko.Practice5.Practice3;

import Shapenko.Practice5.MyExceptions.MyDateException;
import Shapenko.Practice5.MyExceptions.MyNumberException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/*Цей клас відповідає за введення данних і викликає методи для обробки інформації.
 * Читає з консолі за допомогою класу Scanner. Іноді Scanner неправильно працює, тому
 * для перевірки і виправлення викликається метод checkInput. Також в цьому класі знаходяться
 * методи із завдання */
public class Input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int quantity=0;
        System.out.println("Кількість платежів для вводу:");
        while (true) {
            try {


                quantity = sc.nextInt();
                if(quantity<1){
                    throw new MyNumberException("Quantiy has to be more than 0");
                }
                break;
            }catch (InputMismatchException ex){
                System.out.println("Not a number. Please input number");
                sc.nextLine();
            }catch (MyNumberException ex){
                System.out.println(ex.getMessage());
            }
        }
        Payment[] payments=new Payment[quantity];
        for(int i=0;i<quantity;i++){
            Payment payment=new Payment();
            System.out.println("Id");
            payment.setId(sc.nextLong());
            System.out.println("Призначення");
            sc.nextLine();
            payment.setAppointment(sc.nextLine());
            System.out.println("Сума");
            payment.setSum(sc.nextDouble());
            System.out.println("МФО банку");
            sc.nextLine();
            payment.setBankInform(sc.nextLine());
            System.out.println("Розрохунковий рахунок");
            payment.setBill(sc.nextLine());
            System.out.println("Дата(формат 31.05.1999)");
            while (true) {
                try {


                    DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                    String s = sc.nextLine();
                    if (s.equalsIgnoreCase("") || s.equalsIgnoreCase(" ")) {
                        s = sc.nextLine();
                    }
                    Date date = df.parse(s);
                    if(date.before(new Date(1980,1,1))){
                        throw new MyDateException("Payment is too old. Try again");
                    }
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTime(date);
                    payment.setData(cal);
                    break;
                }catch (ParseException ex){
                    System.out.println("Wrong Date. Try Again");
                }catch (MyDateException ex1){
                    System.out.println(ex1.getMessage());
                }
            }

            payments[i]=payment;

        }

        System.out.println("Введіть призначення: ");
        withAppointment(payments,sc.nextLine());

        while (true) {
            try {


                System.out.println("Введіть суму: ");
                double sum = sc.nextDouble();
                findSum(payments, sum);
                if(sum<0){
                    throw new MyNumberException("Sum has to be more 0. Try again");
                }
                break;
            }catch (InputMismatchException ex){
                System.out.println("Please input numbers.");
                sc.nextLine();
            }catch (MyNumberException ex){
                System.out.println(ex.getMessage());
            }
        }
        while (true) {
            try {


                System.out.println("Введіть першу дату (формат 31.05.1999)");
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
                String s = sc.nextLine();
                if (s.equalsIgnoreCase("") || s.equalsIgnoreCase(" ")) {
                    s = sc.nextLine();
                }
                Date date = df.parse(s);
                GregorianCalendar cal1 = new GregorianCalendar();
                cal1.setTime(date);
                System.out.println("Введіть другу дату (формат 31.05.1999)");
                DateFormat df1 = new SimpleDateFormat("dd.MM.yyyy");
                Date date1 = df1.parse(sc.nextLine());
                GregorianCalendar cal2 = new GregorianCalendar();
                cal2.setTime(date1);
                dataDifference(payments, cal1, cal2);
                break;
            }catch (ParseException ex){
                System.out.println("Wrong data. Try again");
            }
        }




    }
    private static void withAppointment(Payment[] payments, String appointment){
        boolean bad=false;
        for (Payment payment:payments){
            if(payment.getAppointment().equalsIgnoreCase(appointment)) {
                System.out.println(payment);
                bad = true;
            }
        }
        if(!bad){
            System.out.println("Немай платежів з таким призначенням");
        }
    }
    private static void findSum(Payment[] payments, double sum){
        boolean bad=false;
        for (Payment payment:payments){
            if(payment.getSum()>sum) {
                System.out.println(payment);
                bad = true;
            }
        }
        if(!bad){
            System.out.println("Немай платежів з такими сумами");
        }
    }
    private static void dataDifference(Payment[] payments, GregorianCalendar date1, GregorianCalendar date2){
        boolean bad=false;
        for (Payment payment:payments){
            if(payment.getData().after(date1)&&payment.getData().before(date2)) {
                System.out.println(payment);
                bad = true;
            }
        }
        if(!bad){
            System.out.println("Немай платежів в такому діапазоні дат");
        }
    }
}
