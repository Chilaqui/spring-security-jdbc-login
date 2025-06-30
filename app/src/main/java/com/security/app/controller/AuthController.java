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

    @GetMapping("/ad")
    public String us(){
        return "Hola admin";
    }


}
