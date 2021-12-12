package com.bloomtech.bloomtech.services.implementations;

import com.bloomtech.bloomtech.models.entities.Email;
import com.bloomtech.bloomtech.services.interfaces.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String remitente;

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public String enviarEmail(Email request){
        MimeMessage mensaje = javaMailSender.createMimeMessage();
        try{
            //se habilita el uso de html
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);
            helper.setTo(request.getTo());
            helper.setFrom(remitente);
            //helper.setFrom(request.getFrom()); si el remitente es otro
            helper.setText(request.getText());
            helper.setSubject(request.getSubject());
            javaMailSender.send(mensaje);
        }catch (Exception e){
            return "Error al enviar al correo" + e.getMessage();
        }
        return "correo enviado";
    }
}
