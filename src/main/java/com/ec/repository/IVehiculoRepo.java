package com.ec.repository;


import com.ec.entity.Vehiculo;

import java.util.List;

public interface IVehiculoRepo {
    List<Vehiculo> buscarTodos();
    Vehiculo buscarPlaca(String placa);


}
