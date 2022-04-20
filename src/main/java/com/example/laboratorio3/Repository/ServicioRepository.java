package com.example.laboratorio3.Repository;

import com.example.laboratorio3.Entity.Mascota;
import com.example.laboratorio3.Entity.Servicio;
import com.example.laboratorio3.dto.detalleServicios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    @Query(value="SELECT  COUNT(idservicio) FROM servicio INNER JOIN mascota on mascota_idmascota=idmascota GROUP BY mascota_idmascota;\n",nativeQuery = true)
    List<Mascota> listaMascotitas();

    @Query(value="SELECT * FROM servicio WHERE mascota_idmascota=?1;",nativeQuery = true)
    List<detalleServicios> detalleServicios();

}
