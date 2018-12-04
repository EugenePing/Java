package Shapenko.Practice5.Practice3;

import java.util.GregorianCalendar;

/*Цей клас - це об'єктно-орієнтоване уявлення про платіж. Логіки ніякої в ньому немає.
 * Це звичайне POJO для збереження і зберігання інформації*/
public class Payment {
    private long id;
    private String appointment;
    private double sum;
    private String bankInform;
    private String bill;
    private GregorianCalendar data;

    public Payment(long id, String appointment, double sum, String bankInform, String bill, GregorianCalendar data) {
        this.id = id;
        this.appointment = appointment;
        this.sum = sum;
        this.bankInform = bankInform;
        this.bill = bill;
        this.data = data;
    }

    public Payment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getBankInform() {
        return bankInform;
    }

    public void setBankInform(String bankInform) {
        this.bankInform = bankInform;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    @Override
    public String toString() {
      return "id : "+id+" - appointment : "+appointment+" - sum : "+sum+" - bankInform : "+bankInform+" - bill : "+bill+" - date : "+data.getTime();
    }
}
