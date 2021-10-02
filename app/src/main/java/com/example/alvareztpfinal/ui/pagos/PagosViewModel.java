package com.example.alvareztpfinal.ui.pagos;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.alvareztpfinal.modelo.Contrato;
import com.example.alvareztpfinal.modelo.Inmueble;
import com.example.alvareztpfinal.modelo.Pago;
import com.example.alvareztpfinal.request.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class PagosViewModel  extends AndroidViewModel
{

    private MutableLiveData<ArrayList<Pago>> pagosMutable;
    private Context context;


    public PagosViewModel(@NonNull Application application)
    {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<ArrayList<Pago>> getPagos()
    {
        if (pagosMutable == null)
        {
            pagosMutable = new MutableLiveData<>();
        }
        return pagosMutable;
    }

    //Acá hacemos una consulta a la ApiClient para traer los inmuebles con un contrato y sus pagos

    public void cargarInmueblesConPagos(Bundle bundle)
    {

        ApiClient api = ApiClient.getApi();
        Contrato contrato = (Contrato) bundle.getSerializable("pagos");

        //retorna los pagos de un Contrato...
        pagosMutable.setValue(api.obtenerPagos(contrato));


    }

}