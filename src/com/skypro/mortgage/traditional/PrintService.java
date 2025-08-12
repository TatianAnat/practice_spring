package com.skypro.mortgage.traditional;

public class PrintService {

    static {
        ServiceLocator.setService(new PrintService("A4"));
    }

    private String paper;

    public PrintService(String paper) {
        this.paper = paper;
    }

    public void print(int listNumber) {
        System.out.println("Печатаем " + listNumber + " листов " + paper);
    }
}
