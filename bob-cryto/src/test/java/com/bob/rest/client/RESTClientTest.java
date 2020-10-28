package com.bob.rest.client;

import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RESTClientTest {


    @Test
    public void testBulkConvertCurrencyValues() throws IOException {
        Set<String> crytoNames = new HashSet<>();
        crytoNames.add("BTC");
        crytoNames.add("ETH");
        crytoNames.add("XRP");
        Map<String, Double> results = RESTClient.bulkConvertCurrencyValues(crytoNames);
        assertTrue(results.get("BTC") > 0);
        assertTrue(results.get("ETH") > 0);
        assertTrue(results.get("XRP") > 0);


    }

    @Test
    public void testGetValueByCrytoID() throws IOException {
        Double value = RESTClient.getValueByCrytoID("BTC");
        assertNotNull(value);
        assertTrue(value > 0);
    }
}
