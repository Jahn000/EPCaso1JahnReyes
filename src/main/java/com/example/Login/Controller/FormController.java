/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Login.Controller;

import com.example.Login.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class FormController {
    
    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("login", new Login()); 
        return "login"; 
    }

    @PostMapping("/login")
    public String showForm(Login login, Model model){
       
        if("admin".equals(login.getUsuario()) && "admin".equals(login.getContraseña())) {
            return "success"; 
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "login"; 
        }
    }
}
