package com.ec.service;

import com.ec.entity.Vehiculo;
import com.ec.service.to.VehiculoTO;

import java.util.List;

public interface IVehiculoService {
    List<Vehiculo> buscarTodos();
    Vehiculo buscarPlaca(String placa);

    List<VehiculoTO> buscarVehiculosTO();
}
