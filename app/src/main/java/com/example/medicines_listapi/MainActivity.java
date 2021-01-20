package com.example.medicines_listapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.medicines_listapi.API.apiClient;
import com.example.medicines_listapi.API.apiService;
import com.example.medicines_listapi.Model.Response;

import okhttp3.MultipartBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;// = ApiClient.getClient();
    private apiService api;//= retrofit.create(ApiService.class);
    private MultipartBody.Part part;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intFunction();
        intApi();



    }


    private void intApi() {
        retrofit = apiClient.getClient();
        api = retrofit.create(apiService.class);


        Call<Response> call;
        call = api.medicinelist();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.body() != null) {
                    Log.d("testing", "onResponse: "+response.body().getMedicines().get(0).getDosage());
                    Log.d("testing", "onResponse: "+response.body().getMedicines().get(0).getDrugs());

                    MyAdeptar adeptar = new MyAdeptar(MainActivity.this, response.body().getMedicines());
                    recyclerView.setAdapter(adeptar);


                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });


    }

    private void intFunction() {
        recyclerView = findViewById(R.id.Recyelid1);

        //Layout Managemnet
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.VERTICAL, false);
        //recyclerview set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
    }


}


