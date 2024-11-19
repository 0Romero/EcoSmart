package com.example.ecosmart.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsumptionService {
    @Autowired
    private ConsumptionRepository consumptionRepository;

    public List<Consumption> findByDeviceId(Long deviceId) {
        return consumptionRepository.findByDeviceId(deviceId);
    }

    public Consumption saveConsumption(Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    public void deleteConsumption(Long id) {
        consumptionRepository.deleteById(id);
    }
}