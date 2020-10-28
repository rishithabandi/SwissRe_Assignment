package com.bob.rest.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RESTClient {

    public static final String REST_URL = "https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=EUR";


    /**
     * Calculates the latest unit values of a set of Crypto types
     *
     * @param crytoNames input set of currency types
     * @return a map where each key-value pair represent  currency type and its unit value respectively
     * @throws IOException
     */
    public static Map<String, Double> bulkConvertCurrencyValues(Set<String> crytoNames) throws IOException {

        Map<String, Double> conversionMap = new HashMap<>();

        for (String c : crytoNames) {
            double value = getValueByCrytoID(c);
            conversionMap.put(c, value);
        }
        return conversionMap;
    }

    static Double getValueByCrytoID(String c) throws IOException {
        URL url = new URL(String.format(REST_URL, c));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String apiOutput = br.readLine();

        return Double.parseDouble(apiOutput.split(":")[1].split("}")[0]);

    }

}
