package com.example.dell.servicesapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.dell.servicesapi.Model.Batch;
import com.example.dell.servicesapi.Model.ListBatchResult;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListBatchActivity extends AppCompatActivity {
    List<Batch> listBatch = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_batch);
        loadData();
    }
     void loadData(){
         Retrofit retrofit= new Retrofit.Builder()
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl(LoginActivity.BASE_URL).build();
         APIServices apiServices= retrofit.create(APIServices.class);
         apiServices.getListBatch("madara","madara").enqueue(new Callback<ListBatchResult>() {
             @Override
             public void onResponse(Call<ListBatchResult> call, Response<ListBatchResult> response) {
                 if (response.isSuccessful()){
                    listBatch= response.body().getBatch();
                 }
             }
             @Override
             public void onFailure(Call<ListBatchResult> call, Throwable t) {

             }
         });
     }
}
