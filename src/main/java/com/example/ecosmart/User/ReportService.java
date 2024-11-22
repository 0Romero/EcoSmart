package com.example.ecosmart.User;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}