package com.sosa.aplicacion1_retrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.sosa.aplicacion1_retrofit.entidades.Posts;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mViewModel;
    private TextView TvleerPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        mViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mViewModel.getLista().observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {

                String valor="";
                for ( int x = 0; x<10;x++  ) {
                    valor += posts.get(x).getId()+" "+posts.get(x).getTitle()+"\n";
                }
                TvleerPost.setText(valor);
            }
        });
        mViewModel.LlenarTV();
    }
    public void inicializar(){
        TvleerPost = this.findViewById(R.id.TVLeerPost);
    }
}