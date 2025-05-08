package com.iit.lab9.controller;

import com.iit.lab9.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private String currentStatus = "Статус невідомо";

    @GetMapping("/")
    public String home(Model model) {
        logger.info("Відображення домашньої сторінки");

        model.addAttribute("status", new Status(currentStatus));
        return "index";
    }

    @PostMapping("/update-status")
    public String updateStatus(Status status) {
        logger.info("Отримано запит на оновлення статусу: {}", status.getMessage());

        this.currentStatus = status.getMessage();
        logger.info("Новий статус: {}", currentStatus);

        return "redirect:/";
    }
}