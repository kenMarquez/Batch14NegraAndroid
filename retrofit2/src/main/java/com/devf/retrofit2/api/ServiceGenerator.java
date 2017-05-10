package com.devf.retrofit2.api;

import retrofit2.Retrofit;
import retrofit2.http.PUT;

/**
 * Created by Ken on 09/05/17.
 */

public class ServiceGenerator {

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl("https://api.github.com");


    public static ApiClient createService() {
        if (retrofit == null) {
            retrofit = builder.build();
        }
        return retrofit.create(ApiClient.class);
    }

}
