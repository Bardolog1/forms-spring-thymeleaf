package com.bardolog.sprinboot.form.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bardolog.sprinboot.form.app.models.domain.User;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController {
	
	
	@GetMapping("/form")
	public String form( Model model) {
		User user = new User();
		user.setId("1254.1254.125-JL");  // seteamos un valor por defecto que no va a ser modificable mediante el formulario, para ensayar el funcionamiento de @SessionAttibutes
		model.addAttribute("title", "Enviar datos formulario");
		model.addAttribute("user", user);

		return "form";
	}
	
	@PostMapping("/form")
	public String processForm(@Valid User user,BindingResult result, Model model, SessionStatus status
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
		//SessionStatus se usa para monitoreas el objeto y eliminar de SessionAttributes al objeto al completar la actualizacion o modificacion de valores en la persistencia
		if(result.hasErrors()) {
			/* Map<String, String > errores = new HashMap<>();
			result.getFieldErrors().forEach(error ->{
				errores.put(error.getField(), "Field: ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
			});
			
			model.addAttribute("error", errores); */
			
			return "form";
			
		}
		
		model.addAttribute("title", "Datos del formulario ...");
		model.addAttribute("user", user);
		status.setComplete();  //le indicamos a la sesion que se finalizo la actualizacion de valores, procede a borrar al objeto de la sesion
		return "results";
	}

}
