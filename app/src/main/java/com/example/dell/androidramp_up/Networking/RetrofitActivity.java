package com.example.dell.androidramp_up.Networking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.androidramp_up.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";
    private static final String TAG = RetrofitActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        final RecyclerView recyclerView = findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<MoviesResponse> call, @NonNull Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getList();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie));
            }

            @Override
            public void onFailure(@NonNull Call<MoviesResponse> call, @NonNull Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
