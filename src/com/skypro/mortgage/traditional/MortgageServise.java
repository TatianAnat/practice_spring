package com.skypro.mortgage.traditional;

public class MortgageServise {
    private ScoringService scoringService;
    private CalculatorService calculatorService;
    private DealService dealService;
    private PrintService printService;

    public MortgageServise(ScoringService scoringService,
                           CalculatorService calculatorService,
                           DealService dealService,
                           PrintService printService) {
        this.scoringService = scoringService;
        this.calculatorService = calculatorService;
        this.dealService = dealService;
        this.printService = printService;
    }

    public void getMortgage() {
        scoringService.scorePerson("Ivan"); //вызывает метод, который будет оценивать человека
        calculatorService.calculatePeriod();//высчитывает график платежей
        dealService.createDeal(); //создавать и регистрировать сделку
        printService.print(10);//печатать договор
    }

    public static void main(String[] args) {
        //заранее создаём все свои зависимости
        ScoringService scoringService1 = new ScoringService();
        CalculatorService calculatorService1 = new CalculatorService();
        CardService cardServiceNspk = new CardService("НСПК");
        DealService dealService1 = new DealService(cardServiceNspk);
        PrintService printService1 = new PrintService("А4");
        System.out.println("Через НСПК");
        MortgageServise mortgageServise = new MortgageServise(scoringService1, calculatorService1, dealService1, printService1);
        mortgageServise.getMortgage();
        System.out.println("Через SWIFT");
        CardService cardServiceSwift = new CardService("SWIFT");
        DealService dealService2 = new DealService(cardServiceSwift);
        //dealService1.setCardService(cardServiceSwift);
        new MortgageServise(scoringService1, calculatorService1, dealService2, printService1).getMortgage();
        mortgageServise.getMortgage();
        System.out.println("Через НСПК");
        mortgageServise.getMortgage();
    }
}
