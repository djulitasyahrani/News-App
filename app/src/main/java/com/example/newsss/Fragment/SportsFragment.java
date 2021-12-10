package com.example.newsss.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsss.Adapter.Adapter;
import com.example.newsss.API.ApiUtilities;
import com.example.newsss.Adapter.ModelClass;
import com.example.newsss.R;
import com.example.newsss.mainNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SportsFragment extends Fragment {

    String api ="2b4e1e7566784e61a86a5440166d0476";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="id";
    private RecyclerView recyclerViewofsports;
    private String category="sports";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sportsfragment, null);

        recyclerViewofsports = v.findViewById(R.id.recyclerviewofsports);
        modelClassArrayList = new ArrayList<>();
        recyclerViewofsports.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewofsports.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category, 100,api).
                enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
