package com.bob.rest.client;

import java.io.IOException;
import java.util.Map;

public class CryptoPortfolioApp {
    public static void main(String[] args) {

        //args =  new String[]{"bobs_crypto.txt"};
        if (args.length != 1) {
            System.out.println("Usage info:");
            System.out.println("CryptoPortfolio  <dataFile>");
            System.exit(-1);
        }

        try {
            Map<String, Integer> prop = FileParser.readPropertiesFile(args[0]);

            Map<String, Double> converstionMap = RESTClient.bulkConvertCurrencyValues(prop.keySet());

            printResults(prop, converstionMap);


        } catch (IOException e) {
            System.out.println("An error occurred due to :" + e.getMessage());
            e.printStackTrace();

        }


    }

    private static void printResults(Map<String, Integer> portfolioMap, Map<String, Double> converstionMap) {
        double totalValue = 0;
        for (String c : portfolioMap.keySet()) {
            int units = portfolioMap.get(c);
            double currentValue = converstionMap.get(c) * units;
            System.out.format("%5s  ( %6s units)  =  %10.2f EUR %n", c, units, currentValue);
            totalValue += currentValue;
        }

        System.out.println("------------------------------------------");
        System.out.format("Total Assets:  %22.2f EUR %n", totalValue);


    }


}
