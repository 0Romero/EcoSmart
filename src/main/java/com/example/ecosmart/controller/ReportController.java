package com.example.ecosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecosmart.User.Report;
import com.example.ecosmart.User.ReportService;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public String showReports(Model model) {
        List<Report> reports = reportService.getAllReports();
        model.addAttribute("reports", reports);
        return "reports";
    }
}
