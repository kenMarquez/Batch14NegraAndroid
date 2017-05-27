package com.devf.retrofitpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.devf.retrofitpost.data.ApiService;
import com.devf.retrofitpost.data.ServiceGenerator;
import com.devf.retrofitpost.data.models.CreateBookRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        post1();


    }

    private void post2() {
        ApiService service = ServiceGenerator.createService(ApiService.class);
        CreateBookRequest createBookRequest = new CreateBookRequest("puto", "puto", "puto", "puto", 2);
        service.createBook2(createBookRequest).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("myLog", response.code() + "");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void post1() {
        ApiService service = ServiceGenerator.createService(ApiService.class);

        service.createBook("Nombre", "apellido", "mexicana", "biogrfica", 2).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("myLog", response.code() + "");

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
