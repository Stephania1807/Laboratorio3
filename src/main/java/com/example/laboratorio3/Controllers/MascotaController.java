package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Entity.Mascota;
import com.example.laboratorio3.Repository.MascotaRepository;
import com.example.laboratorio3.Repository.RazaRepository;
import com.example.laboratorio3.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping(value = {"","/"})
    public String listaMascota(Model model){
        model.addAttribute("listaMascota", mascotaRepository.findAll());
        model.addAttribute("listaRaza", razaRepository.findAll());
        model.addAttribute("listaServicio", servicioRepository.findAll());
        return "Mascota/lista";
    }

    @GetMapping(value={"detalle"})
    public String listaDetalles(@RequestParam("idmascota") int idmascota, Model model){
        Optional<Mascota> mascotaOptional= mascotaRepository.findById(idmascota);
        model.addAttribute("listaServicios", mascotaOptional.get().getListaServicios());
        return "Mascota/detalles";
    }




    public String nuevaMascota(Model model){
        return "Mascota/new";
    }

    @GetMapping("/borrar")
    public String borrarMascota(Model model, @RequestParam("idmascota") int idmascota) {
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(idmascota);
        if (mascotaOptional.isPresent()) {
            Mascota mascota = mascotaOptional.get();
        }
        return "redirect:/mascota";

    }

}
