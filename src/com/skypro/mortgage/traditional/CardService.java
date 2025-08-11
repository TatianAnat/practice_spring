package com.skypro.mortgage.traditional;

public class CardService {

    private String type;

    public CardService(String type) {this.type = type;}

    public void charge(String cardNo, int amount) {
        System.out.println("Система " + type);
        System.out.println("Снимаем деньги: ");
        System.out.println("cardNo = " + cardNo);
        System.out.println("amout = " + amount);
    }
}
