package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Repository.CuentaRepository;
import com.example.laboratorio3.Repository.MascotaRepository;
import com.example.laboratorio3.Repository.ResponsableRepository;
import com.example.laboratorio3.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    ResponsableRepository responsableRepository;

    @GetMapping(value = {"","/"})
    public String listaServicios(Model model){
        model.addAttribute("listaServicios", servicioRepository.findAll());
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuentas", cuentaRepository.findAll());
        model.addAttribute("listaResponsables", responsableRepository.findAll());
        return "servicios/lista";
    }



}
