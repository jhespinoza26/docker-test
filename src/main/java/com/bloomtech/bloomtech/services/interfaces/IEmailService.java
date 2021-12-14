package com.bloomtech.bloomtech.services.interfaces;

import com.bloomtech.bloomtech.models.entities.Email;

public interface IEmailService {

    void sendSimpleEmail(Email emailBody);
    void sendComplexEmail(String[] to, String subject, String text);
}
