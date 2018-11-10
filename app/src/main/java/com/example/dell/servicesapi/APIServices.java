package com.example.dell.servicesapi;

import com.example.dell.servicesapi.Model.ListBatchResult;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServices {
    @POST("/api/Service/CheckLogin")
    @FormUrlEncoded
    Call<JsonObject> checkLogin(
            @Field("userAPI") String userAPI,
            @Field("passAPI") String passAPI,
            @Field("username") String username,
            @Field("password") String password
            );
    @POST("/api/Service/GetListBatch")
    @FormUrlEncoded
    Call<ListBatchResult> getListBatch(
            @Field("userAPI") String userAPI,
            @Field("passAPI") String passAPI

            );
    @POST("/api/Service/GetBatchDetail")
    @FormUrlEncoded
    Call<ListBatchDetail> getListBatchDetial(
            @Field("userAPI") String userAPI,
            @Field("passAPI") String passAPI,
            @Field("ID") int id
            );

}
