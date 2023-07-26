package org.example;

public class Main {
    public static void main(String[] args) {

        int k =1;
        System.out.println("Hello world!");
        String xpath = "//span[starts-with(@id, 'product-price-"+k+"')]";
        String new1 = "img[starts-with(@id,'product-collection-image-"+k+"')]";
        System.out.println(new1);
    }
}