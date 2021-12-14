package com.bloomtech.bloomtech.controllers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "price")
public class precioController {
    private static String apiKey = "84c7a557-761f-4703-90fa-414eb3781be7";//"b54bcf4d-1bca-4e8e-9a24-22ff2c3d462c";

    @GetMapping(value = "/find", produces = {"application/json"})
    public String printD(){
        String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        List<NameValuePair> paratmers = new ArrayList<NameValuePair>();
        paratmers.add(new BasicNameValuePair("start","1"));
        paratmers.add(new BasicNameValuePair("limit","3"));
        paratmers.add(new BasicNameValuePair("convert","USD"));
        try {
            String result = makeAPICall(uri, paratmers);


            return result;

        } catch (IOException e ) {
            return null;//"Error: cannont access content - " + e.toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public void serialize(String address, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new ObjectMapper().readTree(address));
    }


    //@GetMapping("/buscar")
    @Procedure("application/json")
    public static String makeAPICall(String uri, List<NameValuePair> parameters)
            throws URISyntaxException, IOException {
        String response_content = "";

        URIBuilder query = new URIBuilder(uri);
        query.addParameters(parameters);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());


        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", apiKey);

        CloseableHttpResponse response = client.execute(request);

        try {
            //System.out.println("Resultado: " + response.getStatusLine());
            HttpEntity entity = response.getEntity();

            response_content = EntityUtils.toString(entity);

            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;
    }

}
