package com.skypro.mortgage.traditional;

public class DealService {

    private final CardService cardService; //вложенный сервис

    public DealService(CardService cardService) {
        this.cardService = cardService;
    }
//если он инициализирован единожды final, то никаких сетов быть не может
//    public void setCardService(CardService cardService) {
//        this.cardService = cardService;
//    }

    public  void createDeal() {
        System.out.println("Оформляем сделку");
        cardService.charge("1234",1_000); //вызывает вложенный сервис
    }
}
