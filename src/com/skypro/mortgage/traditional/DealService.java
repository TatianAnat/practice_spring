package com.skypro.mortgage.traditional;

public class DealService {

    private CardService cardService = new CardService("НСПК"); //вложенный сервис

    public  void createDeal() {
        System.out.println("Оформляем сделку");
        cardService.charge("1234",1_000); //вызывает вложенный сервис
    }
}
