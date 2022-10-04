
package com.sistemas.exmenes.servicios;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;
    
    @Autowired
    TemplateEngine templateEngine;
    
    
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
            Context context  = new Context();
            String htmlText = templateEngine.process("email-template", context);
            helper
        }catch(MessagingException e){
           e.printStackTrace();
        }
    }
    
}
