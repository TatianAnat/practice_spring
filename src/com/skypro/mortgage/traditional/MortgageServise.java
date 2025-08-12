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
        ServiceLocator.setService(scoringService1);
        CalculatorService calculatorService1 = new CalculatorService();
        ServiceLocator.setService(calculatorService1);
        CardService cardServiceNspk = new CardService("НСПК");
        ServiceLocator.setService("НСПК",cardServiceNspk);

        CardService cardServiceSwift = new CardService("SWIFT");
        ServiceLocator.setService("SWIFT", cardServiceSwift);
        PrintService printService1 = new PrintService("А4");
        ServiceLocator.setService(printService1);

        System.out.println("Через НСПК");
        MortgageServise mortgageServise = new MortgageServise(
                ServiceLocator.getService(ScoringService.class),
                ServiceLocator.getService(CalculatorService.class),
                new DealService(ServiceLocator.getService(CardService.class,"НСПК")),
                ServiceLocator.getService(PrintService.class));
        mortgageServise.getMortgage();
        System.out.println("Через SWIFT");

        MortgageServise mortgageServise2 = new MortgageServise(
                ServiceLocator.getService(ScoringService.class),
                ServiceLocator.getService(CalculatorService.class),
                new DealService(ServiceLocator.getService(CardService.class,"SWIFT")),
                ServiceLocator.getService(PrintService.class));

        mortgageServise2.getMortgage();
        System.out.println("Опять НСПК");
        mortgageServise.getMortgage();
    }
}
