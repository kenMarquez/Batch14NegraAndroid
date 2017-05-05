package com.devf.jsons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parsearJson4();
    }

    /**
     * Objetivo de este metodo es parsear los colores que se
     * encuentran dentro de JSON
     */
    public void parsearJson1() {
        String jsonString = getString(R.string.json1);
        try {


            JSONObject jsonObject = new JSONObject(jsonString);
            Log.e("myLog", jsonObject.toString(3));

            String red = jsonObject.getString("red");
            Log.e("myLog", "red: " + red);

            String blue = jsonObject.getString("blue");
            Log.e("myLog", "blue: " + blue);

            String cyan = jsonObject.getString("cyan");
            Log.e("myLog", "cyan: " + cyan);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Objetivo imprimir los colores del JSON
     */
    public void parsearJson2() {
        String jsonString = getString(R.string.json2);
        try {

            JSONObject jsonObject = new JSONObject(jsonString);
            Log.e("myLog", jsonObject.toString(3));

            JSONArray colorArray = jsonObject.getJSONArray("colorsArray");

            JSONObject jsonColors = colorArray.getJSONObject(0);

            String red = jsonColors.getString("red");
            Log.e("myLog", "Red: " + red);

            String green = jsonColors.getString("green");
            Log.e("myLog", "Green: " + green);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * Objetivo imprimir los colores del JSON
     */
    public void parsearJson3() {
        String jsonString = getString(R.string.json3);
        try {

            JSONObject jsonObject = new JSONObject(jsonString);
            Log.e("myLog", jsonObject.toString(3));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /**
     * Objetivo imprimir la siguiente estructura obteniendo los datos del JSON
     * salida -> Nombre: Jhon Smith
     * , 25 años Ciudadad : New York,
     * Telefono : 212 555-1234,
     * Fax : 646 555-4567
     */
    public void parsearJson4() {
        String jsonString = getString(R.string.json4);
        try {

            JSONObject jsonObject = new JSONObject(jsonString);
            Log.e("myLog", jsonObject.toString(3));


            String fisrtName = jsonObject.getString("firstName");
            String secondName = jsonObject.getString("lastName");
            int edad = jsonObject.getInt("age");

            JSONObject jsonAddress = jsonObject.getJSONObject("address");
            String city = jsonAddress.getString("city");


            JSONArray jsonPhoneNumbers = jsonObject.getJSONArray("phoneNumber");
            JSONObject jsonPhone1 = jsonPhoneNumbers.getJSONObject(0);
            String type1 = jsonPhone1.getString("type");
            String number1 = jsonPhone1.getString("number");

            JSONObject jsonPhone2 = jsonPhoneNumbers.getJSONObject(1);
            String number2 = jsonPhone2.getString("number");


            Log.e("myLog", "Nombre: " + fisrtName + " " + secondName + " , " + edad + " años");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
