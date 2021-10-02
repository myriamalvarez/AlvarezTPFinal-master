package com.example.alvareztpfinal.ui.inmuebles;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.alvareztpfinal.modelo.Inmueble;
import com.example.alvareztpfinal.request.ApiClient;

import java.util.ArrayList;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> inmueblesMutable;
    private Context context;

    public InmueblesViewModel(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmueblesMutable == null) {
            inmueblesMutable = new MutableLiveData<>();
        }
        return inmueblesMutable;

    }

    public void mostrarInmuebles() {

        ApiClient apiClient= ApiClient.getApi();
        ArrayList<Inmueble> inmuebles = apiClient.obtnerPropiedades();
        this.inmueblesMutable.setValue(inmuebles);

    }



}


