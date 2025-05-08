package com.iit.lab9.controller;

import com.iit.lab9.model.Status;
import org.fluentd.logger.FluentLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private static FluentLogger logger = FluentLogger.getLogger("spring.app", "127.0.0.1", 8080);
    private String currentStatus = "Статус невідомо";

    @GetMapping("/")
    public String home(Model model) {
        Map<String, Object> data = new HashMap<>();
        data.put("message", "Displaying home page");
        logger.log("home", data);

        model.addAttribute("status", new Status(currentStatus));
        return "index";
    }

    @PostMapping("/update-status")
    public String updateStatus(Status status) {
        Map<String, Object> updateData = new HashMap<>();
        updateData.put("message", "Status update request received");
        updateData.put("newStatus", status.getMessage());
        logger.log("status.update", updateData);

        this.currentStatus = status.getMessage();

        Map<String, Object> updatedData = new HashMap<>();
        updatedData.put("message", "Status updated successfully");
        updatedData.put("currentStatus", currentStatus);
        logger.log("status.updated", updatedData);

        return "redirect:/";
    }
}