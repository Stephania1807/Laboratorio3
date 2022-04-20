package com.example.laboratorio3.Controllers;

import com.example.laboratorio3.Entity.Mascota;
import com.example.laboratorio3.Entity.OpcionServicio;
import com.example.laboratorio3.Entity.Servicio;
import com.example.laboratorio3.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    OpcionServicioRepository opcionServicioRepository;

    @GetMapping(value = {"","/"})
    public String listaServicios(Model model){
        model.addAttribute("listaServicios", servicioRepository.findAll());
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuentas", cuentaRepository.findAll());
        model.addAttribute("listaResponsables", responsableRepository.findAll());
        model.addAttribute("listaOpcionesServicios", opcionServicioRepository.findAll());

        return "servicios/lista";
    }

    @GetMapping("/new")
    public String nuevoServicio(Model model, @ModelAttribute("servicio") Servicio servicio){
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        model.addAttribute("listaCuentas", cuentaRepository.findAll());
        model.addAttribute("listaResponsables", responsableRepository.findAll());
        return "servicios/newForm";
    }

    @PostMapping("/save")
    public String guardarInventario(Servicio servicio) {
        servicioRepository.save(servicio);
        return "redirect:/servicios";
    }

    @GetMapping(value = "/editar")
    public String editarMascota(Model model, @ModelAttribute("servicio") Servicio servicio,@RequestParam("id") Integer id){
        Optional<Servicio> optional= servicioRepository.findById(id);
        if (optional.isPresent()){
            model.addAttribute("servicio",optional.get());
            model.addAttribute("listaMascotas", mascotaRepository.findAll());
            model.addAttribute("listaCuentas", cuentaRepository.findAll());
            model.addAttribute("listaResponsables", responsableRepository.findAll());
            return "servicios/newForm";
        }

        return "redirect:/servicios";
    }

}
