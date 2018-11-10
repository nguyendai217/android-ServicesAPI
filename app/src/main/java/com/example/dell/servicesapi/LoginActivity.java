package com.example.dell.servicesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    public static String BASE_URL = "http://winds.hopto.org/";
    Button btnLogin;
    EditText edtName, edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        init();
    }

    private void init() {
        btnLogin= findViewById(R.id.btn_login);
        edtName=findViewById(R.id.edt_name);
        edtPass=findViewById(R.id.edt_pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    void login(){
        Retrofit retrofit= new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build();
        APIServices apiServices= retrofit.create(APIServices.class);
        apiServices.checkLogin("madara",
                "madara",
                "admin",
                "admin")
                .enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()){
                    int code = response.body().get("code").getAsInt();
                    if (code==1){
                        Intent intent= new Intent(LoginActivity.this,ListBatchActivity.class);
                        startActivity(intent);
                    }
                    Log.d("respone", "onResponse: "+ response.body());
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }
}
