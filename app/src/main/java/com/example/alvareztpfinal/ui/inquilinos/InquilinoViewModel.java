package com.example.alvareztpfinal.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.alvareztpfinal.modelo.Inmueble;
import com.example.alvareztpfinal.modelo.Inquilino;
import com.example.alvareztpfinal.request.ApiClient;

public class InquilinoViewModel extends ViewModel {

    private MutableLiveData<Inquilino> inquilinoMutable;

    public InquilinoViewModel() {
        super();
    }

    public LiveData<Inquilino> getInquilino() {
        if (inquilinoMutable == null) {
            inquilinoMutable = new MutableLiveData<>();
        }
        return inquilinoMutable;
    }

    public void cargarInquilino(Bundle bundle) {

        Inmueble inmueble = (Inmueble) bundle.get("inmueble");
        ApiClient apiClient= ApiClient.getApi();
        Inquilino inquilino = apiClient.obtenerInquilino(inmueble);
        this.inquilinoMutable.setValue(inquilino);



    }


}
