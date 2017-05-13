package com.devf.retrofitpost.data;

import com.devf.retrofitpost.data.models.CreateBookRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ken on 12/05/17.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("/api/v1/authors/")
    public Call<ResponseBody> createBook(
            @Field("nombre") String name,
            @Field("apellidos") String apellido,
            @Field("nacionalidad") String nacionalidad,
            @Field("biografia") String biografia,
            @Field("edad") int edad);


    @POST("/api/v1/authors/")
    public Call<ResponseBody> createBook2(
            @Body CreateBookRequest bookRequest);

    @GET("/api/v1/authors/")
    public Call<ResponseBody> getBooks();
}
