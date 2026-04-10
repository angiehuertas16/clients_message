package com.symplifica.clients_mesage;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import com.symplifica.clients_message.service.EmailService;

import jakarta.mail.internet.MimeMessage;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private MimeMessage mimeMessage;

    @InjectMocks
    private EmailService emailService;

    @Test
    void shouldSendEmailWithSummary() throws Exception {
        String summary = "Este es un resumen generado por IA";
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        emailService.sendEmail(summary);
        verify(mailSender).createMimeMessage();
        verify(mailSender).send(mimeMessage);
        verify(mailSender, times(1)).send(mimeMessage);
    }
	
	
	
}
