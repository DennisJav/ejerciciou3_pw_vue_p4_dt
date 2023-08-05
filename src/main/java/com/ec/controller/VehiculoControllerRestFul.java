package com.ec.controller;

import com.ec.entity.Vehiculo;
import com.ec.service.IVehiculoService;
import com.ec.service.to.VehiculoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin
public class VehiculoControllerRestFul {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VehiculoTO>> buscarVehiculosTO(){

        List<VehiculoTO> listaTO=this.vehiculoService.buscarVehiculosTO();

        for (VehiculoTO vehi:listaTO) {
            Link myLink = linkTo(methodOn(VehiculoControllerRestFul.class).buscarLista(vehi.getPlaca())).withSelfRel();
            vehi.add(myLink);
        }
        return new ResponseEntity<>(listaTO,null,200);

    }

    @GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehiculo> buscarLista(@PathVariable String placa){
         Vehiculo vehi = this.vehiculoService.buscarPlaca(placa);
        return new ResponseEntity<Vehiculo>(vehi,null,200);
    }

}
