package com.example.medicines_listapi.API;

import com.example.medicines_listapi.Model.Response;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface apiService {




    @GET("medicine-list.php")
    Call<Response> medicinelist();

}
