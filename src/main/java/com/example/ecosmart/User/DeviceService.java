package com.example.ecosmart.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> findDevicesByUser(Long userId) {
        return deviceRepository.findByUserId(userId);
    }

    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findDeviceById(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}
