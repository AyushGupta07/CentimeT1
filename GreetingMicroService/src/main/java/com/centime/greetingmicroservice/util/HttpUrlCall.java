package com.centime.greetingmicroservice.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpUrlCall {


    public static String sendReqHttpPost(Object payload, String url) {
        try {
            Gson gsonObj = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
            String jsonPayLoad = gsonObj.toJson(payload);

            // System.out.println(jsonPayLoad);

            CloseableHttpClient client = HttpClients.createDefault();

            HttpPost httpPost = new HttpPost(url);

            RequestConfig.Builder requestConfig = RequestConfig.custom();
            requestConfig.setConnectTimeout(15000);
            requestConfig.setConnectionRequestTimeout(15000);
            requestConfig.setSocketTimeout(15000);
            httpPost.setConfig(requestConfig.build());

            StringEntity entity = new StringEntity(jsonPayLoad);

            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
//            for(Map.Entry<String,String> e : headers.entrySet()) {
//                httpPost.setHeader(e.getKey(), e.getValue());
//            }

            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println("Response Headers --- " + new Gson().toJson(response.getAllHeaders()));
            System.out.println("Response Entity --- " + response.getEntity().toString());
            System.out.println("---- Response :" + response.toString());

            InputStream is = response.getEntity().getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            StringBuilder str = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                str.append(line);
            }

            System.out.println("###### API RESPONSE :" + str.toString());

            return str.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sendReqHttpGet(String url) {
        try {
//            Gson gsonObj = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
//            String jsonPayLoad = gsonObj.toJson(payload);

            // System.out.println(jsonPayLoad);

            CloseableHttpClient client = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(url);

            RequestConfig.Builder requestConfig = RequestConfig.custom();
            requestConfig.setConnectTimeout(15000);
            requestConfig.setConnectionRequestTimeout(15000);
            requestConfig.setSocketTimeout(15000);
            httpGet.setConfig(requestConfig.build());

            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-type", "application/json");


            CloseableHttpResponse response = client.execute(httpGet);
            System.out.println("Response Headers --- " + new Gson().toJson(response.getAllHeaders()));
            System.out.println("Response Entity --- " + response.getEntity().toString());
            System.out.println("---- Response :" + response.toString());

            InputStream is = response.getEntity().getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            StringBuilder str = new StringBuilder();
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                str.append(line);
            }

            System.out.println("###### API RESPONSE :" + str.toString());

            return str.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
