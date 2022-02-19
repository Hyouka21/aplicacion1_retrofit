package com.sosa.aplicacion1_retrofit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sosa.aplicacion1_retrofit.entidades.Posts;
import com.sosa.aplicacion1_retrofit.request.Request;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Posts>> lista ;

    public MutableLiveData<List<Posts>> getLista() {
        if(lista == null){
            lista = new MutableLiveData<>();
        }
        return lista;
    }

    public void LlenarTV(){
        Call<List<Posts>> listCall = Request.getMyApiClient().obtenerPosts();
        listCall.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if(response.isSuccessful()){
                    lista.postValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }
}
