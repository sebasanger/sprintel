package com.sanger.sprintel.utils.mail;

public interface EmailService {
    public void sendMail(String toEmail, String subject, String message);
}
