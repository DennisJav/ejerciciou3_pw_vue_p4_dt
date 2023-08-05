package com.ec.repository;

import com.ec.entity.Vehiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class VehiculoRepoImpl implements IVehiculoRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vehiculo> buscarTodos() {
        TypedQuery<Vehiculo> myQuery = this.entityManager
                .createQuery("Select v from Vehiculo v",Vehiculo.class );
        return myQuery.getResultList();
    }

    @Override
    public Vehiculo buscarPlaca(String placa) {
        TypedQuery<Vehiculo> myQuery = this.entityManager
                .createQuery("Select v from Vehiculo v Where v.placa = :dato", Vehiculo.class);
        myQuery.setParameter("dato", placa);

        return myQuery.getSingleResult();

    }
}
