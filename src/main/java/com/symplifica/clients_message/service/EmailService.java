package com.symplifica.clients_message.service;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String summary) throws Exception {

        String htmlTemplate = new String(
                Files.readAllBytes(Paths.get("src/main/resources/templates/news-email.html"))
        );

        String htmlContent = htmlTemplate.replace("{{summary}}", summary);

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper =
                new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo("esteban_-456@hotmail.com");
        helper.setSubject("Resumen diario generado con IA");
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}