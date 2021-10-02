package com.example.alvareztpfinal.ui.inmuebles;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.alvareztpfinal.modelo.Inmueble;
import com.example.alvareztpfinal.request.ApiClient;

public class InmuebleViewModel extends ViewModel {

    private MutableLiveData<Inmueble> inmuebleMutable;

    public InmuebleViewModel() {
        super();
    }

    public LiveData<Inmueble> getInmueble() {
        if (inmuebleMutable == null) {
            inmuebleMutable = new MutableLiveData<>();
        }
        return inmuebleMutable;
    }

    public void cargarInmueble(Bundle bundle){
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        inmuebleMutable.setValue(inmueble);
    }


    public void actualizarDatosInmueble(Inmueble inmueble){
        ApiClient apiClient = ApiClient.getApi();
        apiClient.actualizarInmueble(inmueble);
        this.inmuebleMutable.setValue(inmueble);
    }

}
