package com.skypro.mortgage.traditional;

public class CalculatorService {

    static {
        ServiceLocator.setService(new CalculatorService());
    }

    public void calculatePeriod() {
        System.out.println("Составление графика расчетов ");
    }
}
