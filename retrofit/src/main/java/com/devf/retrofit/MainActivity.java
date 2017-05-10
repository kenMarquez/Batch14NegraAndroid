package com.devf.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataGithub();

    }

    private void getDataGithub() {

        /**
         * Configuración basica de nuestro objeto Retrofit
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

        /**
         * Creo la instancia de mi interfaz que ya tiene configurado la estructura  de mis solicitudes
         */
        GitHubService gitHubService = retrofit.create(GitHubService.class);

        gitHubService.getUserInfoPath("ericklarac").enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //Obtengo el código de respuesta
                int code = response.code();

                //Verifico que el código sea 200
                if (code == 200) {
                    if (response.body() != null) {
                        try {
                            //Obtenemos el body del mensaje HTTP como String
                            String body = response.body().string();
                            //Parseo el String como JSON
                            JSONObject jsonObject = new JSONObject(body);
                            Log.e("myLog", jsonObject.toString(4));
                            Log.e("myLog", "name: " + jsonObject.getString("name"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (code == 404) {
                    //Si no encontrio al usuario manda un mensaje
                    Toast.makeText(MainActivity.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("myLog", "algo salio mal");
            }
        });


    }


    private interface GitHubService {

        /**
         * Nombre del metodo
         * uri del recurso que queremos obtener
         */
        @GET("/users/kenMarquez")
        public Call<ResponseBody> getUserInfo();

        /**
         * Nombre del metodo
         * uri del recurso que queremos obtener
         */
        @GET("/users/{username}")
        public Call<ResponseBody> getUserInfoPath(@Path("username") String userName);


    }


}
