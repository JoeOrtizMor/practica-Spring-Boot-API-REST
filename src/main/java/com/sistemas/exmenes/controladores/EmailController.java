
package com.sistemas.exmenes.controladores;

import com.sistemas.exmenes.servicios.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {
    
    @Autowired
    EmailService emailService;
    
    @GetMapping()
    public ResponseEntity<?> sendEmail(){
        emailService.sendEmail();
        return new ResponseEntity<>("Correo enviado con exito",HttpStatus.OK);
    }
    
}
