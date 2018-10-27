package com.mmall.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class Test {
    //    @org.junit.Test
    public void main() {
        HashSet<Integer> allProductPrice = new HashSet<Integer>(5);
//        allProductPrice.add();

        int sumc = sum(100, allProductPrice);
        System.out.println(sumc);
    }

    public int sum(int maxprice, Set<Integer> price) {
        int countPrice = 0;
        for (Integer PriceItem : price) {
            if (PriceItem <= 10000 && PriceItem > 0) {
                countPrice += PriceItem;
            }
        }
        return countPrice <= maxprice ? countPrice : -1;
    }

    public static void main2(String[] args) {
        int countPrice = 0;
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        System.out.println(sum);
        //获取单个价格，空格分割100
        Scanner scanner1 = new Scanner(System.in);
        String nextLine1 = scanner1.nextLine();
        String[] split = nextLine1.split(" ");
        for (String s : split) {
            countPrice += Integer.valueOf(s);
        }
        if (countPrice > sum) {
            System.out.println("预算超额！");
        }
        System.out.println(countPrice);
    }





    public static void main(String[] args) {
        String A = "ABCDEFGHI";
        String B = "JKLMNOPQR";
        String C = "STUVWXYZ*";

        Scanner scanner = new Scanner(System.in);
        String sum = scanner.nextLine();

        String[] split = sum.split(" ");
        int mon = 0;
        int day = 0;

        mon = Integer.valueOf(split[0]) -1;
        day = Integer.valueOf(split[1]) -1;

        String abc = "ABC";
        abc = leftMoveIndex(abc,mon);
        A = leftMoveIndex(A,day);
        B = leftMoveIndex(B,day);
        C= leftMoveIndex(C,day);

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = abc.toCharArray();
        for(int i=0;i<= chars.length-1;i++){
           String resever =chars[i] + "";
           if(resever.equals("C")){
               stringBuilder.append(C).append(",");
           }
           if(resever.equals("B")){
               stringBuilder.append(B).append(",");
           }
           if(resever.equals("A")){
               stringBuilder.append(A).append(",");
           }
        }

        System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
//        System.out.println(sum);
//        //获取单个价格，空格分割100
//        Scanner scanner1 = new Scanner(System.in);
//        String nextLine1 = scanner1.nextLine();
//        String[] split = nextLine1.split(" ");
//        for (String s : split) {
//            countPrice += Integer.valueOf(s);
//        }
//        if (countPrice > sum) {
//            System.out.println("预算超额！");
//        }
//        System.out.println(countPrice);
    }


    public static String reverse1(String s){
        char []array=s.toCharArray();
        String resever="";
        for(int i=array.length-1;i>=0;i--){
            resever+=array[i];

        }
        return resever;

    }

    public static String leftMoveIndex(String from,int index){
        String first = from.substring(0,index);
        String second = from.substring(index);
        first = reChange(first);
        second = reChange(second);
        from = first + second;
        from = reChange(from);
        return from;
    }

    public static String reChange(String from){
        char[] froms = from.toCharArray();
        int length = froms.length;
        for (int i = 0; i < length/2; i++){
            char temp = froms[i];
            froms[i] = froms[length - 1 -i];
            froms[length - 1 -i] = temp;
        }
        return String.valueOf(froms);
    }

    public static void main1(String[] args) {

        System.out.println(leftMoveIndex("123456", 2));
    }
}