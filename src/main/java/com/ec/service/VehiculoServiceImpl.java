package com.ec.service;

import com.ec.entity.Vehiculo;
import com.ec.repository.IVehiculoRepo;
import com.ec.service.to.VehiculoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    private IVehiculoRepo   vehiculoRepo;
    @Override
    public List<Vehiculo> buscarTodos() {
        return this.vehiculoRepo.buscarTodos();
    }

    @Override
    public Vehiculo buscarPlaca(String placa) {
        return this.vehiculoRepo.buscarPlaca(placa);
    }

    @Override
    public List<VehiculoTO> buscarVehiculosTO() {
        List<Vehiculo> lista=this.buscarTodos();
        List<VehiculoTO> listaTO = lista.stream().map(e->{
            VehiculoTO vehiTO= new VehiculoTO();
            vehiTO.setId(e.getId());
            vehiTO.setMarca(e.getMarca());
            vehiTO.setModelo(e.getModelo());
            vehiTO.setPlaca(e.getPlaca());
            vehiTO.setAnioFabricacion(e.getAnioFabricacion());
            return vehiTO;
                }).collect(Collectors.toList());
        return listaTO;
    }

//    private VehiculoTO convertir(Vehiculo vehiculo){
//        VehiculoTO vehiTO= new VehiculoTO();
//        vehiTO.setId(vehiculo.getId());
//        vehiTO.setMarca(vehiculo.getMarca());
//        vehiTO.setModelo(vehiculo.getModelo());
//        vehiTO.setPlaca(vehiculo.getPlaca());
//        vehiTO.setAnioFabricacion(vehiculo.getAnioFabricacion());
//        return vehiTO;
//    }
}
