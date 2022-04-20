package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    RazaRepository razaRepository;

    @Autowired
    ServicioRepository servicioRepository;
    @GetMapping(value = {"","/"})
    public String listaEmployee(Model model){
        model.addAttribute("listaMascota", mascotaRepository.findAll());
        model.addAttribute("listaRaza", razaRepository.findAll());
        model.addAttribute("listaServicio", servicioRepository.findAll());
        return "Mascota/lista";
    }




    public String nuevaMascota(Model model){
        return "Mascota/new";
    }

}
