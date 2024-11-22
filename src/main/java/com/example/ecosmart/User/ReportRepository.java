package com.example.ecosmart.User;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByDeviceId(Long deviceId);
}
