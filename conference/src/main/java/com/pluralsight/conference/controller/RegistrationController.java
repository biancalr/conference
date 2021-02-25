package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){
        return "registration";
    }

    @PostMapping("registration")
    public String addRegistration(
            @Valid @ModelAttribute("registration")Registration registration,
            BindingResult result){
        System.out.println("Registration: " + registration.getName());

        if (result.hasErrors()){
            System.out.println("There were error");
            return "registration";
        }

        // Adicionar "redirect:" no retorno
        // ajuda a manter o estado da informacao
        // e inibe a sobreposicao e o reenvio
        // de dados: POST-REDIRECT-GET
        return "redirect:registration";
    }
}