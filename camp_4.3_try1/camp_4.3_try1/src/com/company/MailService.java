package com.company;

/*
Теперь рассмотрим классы, которые моделируют работу почтового сервиса:

Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/

public interface MailService {
    Sendable processMail(Sendable mail);
}
