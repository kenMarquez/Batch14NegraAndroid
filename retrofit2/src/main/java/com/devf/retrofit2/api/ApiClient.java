package com.devf.retrofit2.api;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ken on 09/05/17.
 */

public interface ApiClient {


    @GET("/users/kenMarquez/repos")
    Call<ResponseBody> getRepos();

}
