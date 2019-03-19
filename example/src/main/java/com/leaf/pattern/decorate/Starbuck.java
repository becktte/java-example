package com.leaf.pattern.decorate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;

public class Starbuck {
    public static void main(String[] args) throws Exception{
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage1 = new Espresso();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        FileReader fileReader = new FileReader("D:\\test.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String temp = "";
        while ((temp = br.readLine()) != null) {
            System.out.println(temp);
        }

        InputStream is = new FileInputStream("D:\\test.txt");
        byte[] bytes = new  byte[1024];
        int count;
        while((count = is.read(bytes)) > -1) {
            System.out.println(new String(bytes, 0, count));
        }
    }
}
