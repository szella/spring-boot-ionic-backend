package com.sergiozella.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.sergiozella.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
