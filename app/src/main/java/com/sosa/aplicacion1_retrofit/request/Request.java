package com.sosa.aplicacion1_retrofit.request;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sosa.aplicacion1_retrofit.entidades.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class Request {
    private static final String UrlBase="https://jsonplaceholder.typicode.com/";
    private static PostInterface postInterface;

    public static PostInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(UrlBase)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        postInterface=retrofit.create(PostInterface.class);

        return postInterface;
    }

    public interface PostInterface{
        @GET("posts")
        Call<List<Posts>> obtenerPosts();

    }
}
