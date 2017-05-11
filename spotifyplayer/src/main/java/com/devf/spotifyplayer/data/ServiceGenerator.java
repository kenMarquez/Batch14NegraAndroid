package com.devf.spotifyplayer.data;

import com.devf.spotifyplayer.utils.NetworkConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ken on 10/05/17.
 */

public class ServiceGenerator {

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(NetworkConstants.BASE_URL);

    public static SpotifyApi createService() {
        if (retrofit == null) {
            retrofit = builder.build();
        }
        return retrofit.create(SpotifyApi.class);
    }

}
