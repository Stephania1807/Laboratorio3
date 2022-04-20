package com.example.laboratorio3.Repository;

import com.example.laboratorio3.dto.ContactoMascota;
import com.example.laboratorio3.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query(value="select cu.idcuenta as contacto, count(ma.idmascota) as mascotas,  cu.correo, cu.direccion, cu.telefono from cuenta as cu\n" +
            "            left join mascota ma on cu.idcuenta=ma.cuenta_idcuenta\n" +
            "            group by idcuenta;",nativeQuery = true)
    List<ContactoMascota> obtenerContactoMascota();

}
