package com.example.ecosmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecosmart.User.Device;
import com.example.ecosmart.User.DeviceService;
@Controller
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public String showDevices(Model model) {
        model.addAttribute("devices", deviceService.getAllDevices());
        return "devices"; // O nome do template sem a extensão .html
    }
    @PostMapping("/add")
    public String addDevice(@ModelAttribute Device device) {
        deviceService.saveDevice(device);
        return "redirect:/devices";
    }
}
