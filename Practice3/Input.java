package Shapenko.Practice3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/*Цей клас відповідає за введення данних і викликає методи для обробки інформації.
 * Читає з консолі за допомогою класу Scanner. Іноді Scanner неправильно працює, тому
 * для перевірки і виправлення викликається метод checkInput. Також в цьому класі знаходяться
 * методи із завдання */
public class Input {
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);


        System.out.println("Кількість платежів для вводу:");
        int quantity=sc.nextInt();
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
            System.out.println("Розрахунковий рахунок");
            payment.setBill(sc.nextLine());
            System.out.println("Дата(формат 31.05.1999)");
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String s=sc.nextLine();
            if(s.equalsIgnoreCase("")||s.equalsIgnoreCase(" ")){
                s=sc.nextLine();
            }
            Date date = df.parse(s);
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(date);
            payment.setData(cal);
            payments[i]=payment;

        }

        System.out.println("Введіть призначення: ");
        withAppointment(payments,sc.nextLine());
        System.out.println("Введіть суму: ");
        findSum(payments,sc.nextDouble());
        System.out.println("Введіть першу дату (формат 31.05.1999)");
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String s=sc.nextLine();
        if(s.equalsIgnoreCase("")||s.equalsIgnoreCase(" ")){
            s=sc.nextLine();
        }
        Date date = df.parse(s);
        GregorianCalendar cal1 = new GregorianCalendar();
        cal1.setTime(date);
        System.out.println("Введіть другу дату (формат 31.05.1999)");
        DateFormat df1 = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = df1.parse(sc.nextLine());
        GregorianCalendar cal2 = new GregorianCalendar();
        cal2.setTime(date1);
        dataDifference(payments,cal1,cal2);




    }
    private static void withAppointment(Payment[] payments,String appointment){
        boolean bad = false;
        for (Payment payment:payments){
            if(payment.getAppointment().equalsIgnoreCase(appointment)) {
                System.out.println(payment);
                bad = true;
            }
        }
        if(!bad){
            System.out.println("Немає платежів з таким призначенням");
        }
    }
    private static void findSum(Payment[] payments,double sum){
        boolean bad=false;
        for (Payment payment:payments){
            if(payment.getSum()>sum) {
                System.out.println(payment);
                bad = true;
            }
        }
        if(!bad){
            System.out.println("Немає платежів з такими сумами");
        }
    }
    private static void dataDifference(Payment[] payments,GregorianCalendar date1,GregorianCalendar date2){
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
