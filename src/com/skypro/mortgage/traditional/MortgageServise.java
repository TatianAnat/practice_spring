package com.skypro.mortgage.traditional;

public class MortgageServise {
    private ScoringService scoringService = new ScoringService();
    private CalculatorService calculatorService = new CalculatorService();
    private DealService dealService = new DealService();
    private PrintService printService = new PrintService("А4");

    public void getMortgage() {
        scoringService.scorePerson("Ivan"); //вызывает метод, который будет оценивать человека
        calculatorService.calculatePeriod();//высчитывает график платежей
        dealService.createDeal(); //создавать и регистрировать сделку
        printService.print(10);//печатать договор
    }

    public static void main(String[] args) {
        new MortgageServise().getMortgage();
    }
}
