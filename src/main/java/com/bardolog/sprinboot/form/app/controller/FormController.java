package com.bardolog.sprinboot.form.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bardolog.sprinboot.form.app.models.domain.User;

import jakarta.validation.Valid;

@Controller
public class FormController {
	
	
	@GetMapping("/form")
	public String form(User user, Model model) {
		model.addAttribute("title", "Enviar datos formulario");
		model.addAttribute("user", user);

		return "form";
	}
	
	@PostMapping("/form")
	public String processForm(@Valid User user,BindingResult result, Model model
			// @RequestParam String username, 
			//@RequestParam String password,
			//@RequestParam String email
			) {
		
		/*
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email)
		 */
		
		//el BindingResult es el encargado de revisar las validaciones del objeto marcado con el @Valid y dar el aviso de errores, debe estar declarado justamente despues del objeto a validar
		
		if(result.hasErrors()) {
			Map<String, String > errores = new HashMap<>();
			result.getFieldErrors().forEach(error ->{
				errores.put(error.getField(), "Field: ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
			});
			
			model.addAttribute("error", errores);
			
			return "form";
			
		}
		
		model.addAttribute("title", "Datos del formulario ...");
		model.addAttribute("user", user);
		
		return "results";
	}

}
