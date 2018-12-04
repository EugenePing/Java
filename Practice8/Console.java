package Shapenko.Practice8;

import java.util.*;

public class Console {
    private static List<Integer> numbers=new ArrayList<>();

    public static void main(String[] args) {
        populate();
        System.out.println("Start List");
        System.out.println(numbers);
        System.out.println("Result");
        System.out.println(minSearch());
    }


    private static void populate(){
        Random random=new Random();
        for(int i=0;i<40;i++){
            numbers.add(random.nextInt(200));
        }
    }
    private static List<Integer> minSearch(){
        TreeSet<Integer> treeSet=new TreeSet<>(numbers);
        return new ArrayList<>(treeSet).subList(0,10);
    }

}
