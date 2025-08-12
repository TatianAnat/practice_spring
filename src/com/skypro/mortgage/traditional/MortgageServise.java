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
        //не нужно ничего создавать, оно создаётся в статических блоках

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
