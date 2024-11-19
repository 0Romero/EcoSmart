package com.example.ecosmart.User;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionService {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @Autowired
    private DeviceService deviceService;

    public List<Consumption> findByDeviceId(Long deviceId) {
        return consumptionRepository.findByDeviceId(deviceId);
    }

    public Consumption saveConsumption(Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    public void deleteConsumption(Long id) {
        consumptionRepository.deleteById(id);
    }

    // Método para simular coleta de dados de consumo em tempo real
    @Scheduled(fixedRate = 60000) // Executa a cada 60 segundos
    public void monitorDevices() {
        List<Device> devices = deviceService.getAllDevices();
        for (Device device : devices) {
            double simulatedConsumption = simulateConsumption(device);
            if (simulatedConsumption > device.getMaxAllowedConsumption()) {
                sendAlert(device, simulatedConsumption);
            }
            saveConsumption(new Consumption(device, simulatedConsumption, LocalDateTime.now()));

        }
    }

    private double simulateConsumption(Device device) {
        // Simulação de consumo variando entre 50% e 150% do consumo máximo permitido
        double max = device.getMaxAllowedConsumption();
        return max * (0.5 + Math.random());
    }

    private void sendAlert(Device device, double consumption) {
        System.out.printf("ALERT: Device %s exceeded consumption limit! Consumption: %.2f%n", device.getName(),
                consumption);
        // Aqui, podemos integrar com um sistema de envio de notificações (e-mail, SMS,
        // etc.)
    }
}
