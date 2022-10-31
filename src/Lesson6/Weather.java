package Lesson6;


import okhttp3.*;

import java.io.IOException;


public class Weather {

    public static final String API_KEY_PARAM = "apikey";
    public static final String API_KEY = "PiutSytY8lbjWo4YITe4tPAxlwHXTaAi";
    public static final String LOCATION_KEY = "295212";
    public static final String RESOURCE_URL = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/" + LOCATION_KEY;

    public static void main(String[] args) throws IOException {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(RESOURCE_URL).newBuilder();
        urlBuilder.addQueryParameter(API_KEY_PARAM, API_KEY);

        HttpUrl httpUrl = urlBuilder.build();

        Request.Builder requestBuilder = new Request.Builder();

        Request request = requestBuilder
                .get()
                .url(httpUrl)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);

        Response response = call.execute();

        System.out.println(response.body().string());
    }
}


