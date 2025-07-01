package com.security.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/admin")
    public ResponseEntity<?> adminEntity(){
        return ResponseEntity.ok("Bien logiado aministrador");
    }

    @GetMapping("/user")
    public ResponseEntity<?> userEntity(){
        return ResponseEntity.ok("Bien logiado usuario");
    }
    // Usuarios de cualquier autetificado
    @GetMapping("/ad")
    public String us(){
        return "Hola admin";
    }

    //Usurios con Admin
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/del")
    public String adminPega(){
        return "Hola admin, esta es pagina es con preauthorizer";
    }


}
