package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Entity.Mascota;
import com.example.laboratorio3.Repository.CuentaRepository;
import com.example.laboratorio3.Repository.MascotaRepository;
import com.example.laboratorio3.Repository.RazaRepository;
import com.example.laboratorio3.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    RazaRepository razaRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @GetMapping(value = {"","/"})
    public String listaMascota(Model model){
        model.addAttribute("listaMascota", mascotaRepository.findAll());
        model.addAttribute("listaRaza", razaRepository.findAll());
        model.addAttribute("listaServicio", servicioRepository.findAll());
        return "Mascota/lista";
    }

    @GetMapping(value = "/new")
    public String nuevaMascota(Model model, @ModelAttribute("mascota")Mascota mascota){
        model.addAttribute("listaCuentas",cuentaRepository.findAll());
        model.addAttribute("listaRazas",razaRepository.findAll());
        return "Mascota/new";
    }

    @PostMapping(value = "save")
    public  String saveMascota(Mascota mascota){
        mascotaRepository.save(mascota);
        return "redirect:/mascota";
    }

    @GetMapping(value = "/edit")
    public String editarMascota(Model model, @ModelAttribute("mascota")Mascota mascota,@RequestParam("id") Integer id){
        Optional<Mascota> optional= mascotaRepository.findById(id);
        if (optional.isPresent()){
            model.addAttribute("mascota",optional.get());
            model.addAttribute("listaCuentas",cuentaRepository.findAll());
            model.addAttribute("listaRazas",razaRepository.findAll());
            return "Mascota/new";
        }

        return "redirect:/mascota";
    }


}
