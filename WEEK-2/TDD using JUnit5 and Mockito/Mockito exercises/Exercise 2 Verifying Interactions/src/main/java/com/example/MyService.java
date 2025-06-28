package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public void processAndSendData(String input) {
        String processedData = "Processed: " + input.toUpperCase();
        int priority = input.equalsIgnoreCase("urgent") ? 1 : 2;
        externalApi.sendData(processedData, priority);
    }
}
