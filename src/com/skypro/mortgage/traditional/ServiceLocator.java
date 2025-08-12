package com.skypro.mortgage.traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ServiceLocator {

    private static final Map<Class, Map<String,Object>> SERVICE_MAP = new HashMap<>();

    static {
        try {
            Class.forName("com.skypro.mortgage.traditional.ScoringService");
            Class.forName("com.skypro.mortgage.traditional.CalculatorService");
            Class.forName("com.skypro.mortgage.traditional.CardService");
            Class.forName("com.skypro.mortgage.traditional.DealService");
            Class.forName("com.skypro.mortgage.traditional.PrintService");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void setService(Object service) {
        SERVICE_MAP.computeIfAbsent(service.getClass(), cls -> new HashMap<>()).put(service.getClass().getName(),service);
    }

    public static void setService(String qualifier, Object service) {
        SERVICE_MAP.computeIfAbsent(service.getClass(), cls -> new HashMap<>()).put(qualifier,service);
    }

    public static <T> T getService(Class<T> serviceClass) {
        return (T) Optional.of(SERVICE_MAP)
                .map(sm -> sm.get(serviceClass))
                .map(m -> m.get(serviceClass.getName()))
                .orElseThrow();
    }

    public static <T> T getService(Class<T> serviceClass, String qualifier) {
        return (T) Optional.of(SERVICE_MAP)
                .map(sm -> sm.get(serviceClass))
                .map(m -> m.get(qualifier))
                .orElseThrow();
    }
}
