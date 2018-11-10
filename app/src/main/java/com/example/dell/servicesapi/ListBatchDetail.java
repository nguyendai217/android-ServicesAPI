package com.example.dell.servicesapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ListBatchDetail  extends AppCompatActivity {
    List<BatchDetial> listbatchDetial = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbatch_detail);

        loadData();
    }

    private void loadData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(LoginActivity.BASE_URL).build();

        APIServices apiServices = retrofit.create(APIServices.class);
        apiServices.getListBatchDetial("madara", "madara", Integer.parseInt("29"))
                .enqueue(new Callback<ListBatchDetail>() {
                    @Override
                    public void onResponse(Call<ListBatchDetail> call, Response<ListBatchDetail> response) {
                        if (response.isSuccessful()) {

                        }

                    }
                    @Override
                    public void onFailure(Call<ListBatchDetail> call, Throwable t) {

                    }
                });

    }

}

