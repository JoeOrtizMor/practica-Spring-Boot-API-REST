
package com.sistemas.exmenes.servicios;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;
    
    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ortizmoralesjoe@gmail.com");
        message.setTo("ortizmoralesjoe@gmail.com");
        message.setSubject("Prueba envio email simple");
        message.setText("Esto es el contenido del email");
        
        javaMailSender.send(message);
    }
    
    public void sendEmailTemplate(){
        MimeMessage message = javaMailSender.createMimeMessage();
        
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true); 
        }catch(MessagingException e){
           e.printStackTrace();
        }
    }
    
}
