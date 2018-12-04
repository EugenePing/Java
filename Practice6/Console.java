package Shapenko.Practice6;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true)

        {
            System.out.println("Please file path ");
            String fileName = scanner.nextLine();
            fileName = checkInput(fileName, scanner);
            try {
                String line;
                StringBuilder sb=new StringBuilder();
                BufferedReader reader=new BufferedReader(new FileReader(fileName));
                while ((line=reader.readLine())!=null){
                    sb.append(line).append("\n");
                }

                String[] text=sb.toString().split("\n");

                    changeWords(text);
                    sb=new StringBuilder();

                for (String s : text) {
                    sb.append(s).append("\n");
                }


                FileOutputStream fos=new FileOutputStream(fileName);
                    fos.write(sb.toString().getBytes(Charset.defaultCharset()));
                    fos.flush();
                    fos.close();


                break;
            } catch (FileNotFoundException e) {
                System.out.println("Wrong file name. Try again");
            } catch (IOException e) {
                System.out.println("Something wrong with input stream.");
                e.printStackTrace();
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

    private static void changeWords(String[] lines){
        for(int i=0;i<lines.length;i++){

            String[] arr=lines[i].split(" ");
            if(arr.length<2){
                break;
            }
            else {
                String temp=arr[0];
                arr[0]=arr[arr.length-1];
                arr[arr.length-1]=temp;
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<arr.length;j++){
                    sb.append(arr[j]).append(" ");
                }
                lines[i]=sb.toString();
            }
        }

    }
}
