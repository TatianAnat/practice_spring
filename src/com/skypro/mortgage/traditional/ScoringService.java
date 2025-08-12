package com.skypro.mortgage.traditional;

public class ScoringService {

    static {
        ServiceLocator.setService(new ScoringService());
    }

    public void scorePerson(String name) {
        System.out.println("Оценка платежеспособности " + name);
    }
}
