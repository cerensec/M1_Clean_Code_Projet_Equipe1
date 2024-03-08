package com.api.veloconnecte;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class VeloconnecteApplication {
    private static final Logger LOGGER = LogManager.getLogger(VeloconnecteApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VeloconnecteApplication.class, args);
    }

    // @Scheduled(fixedRate = 1000)
    // public void readerDataFromCapture() {
    // double meters = distanceFromWheelService.calculateDistanceInMeters(WheelMichelen,
    // capteurPoc.getNomberRatation());
    //
    // capteurService.sendDistanceFromCapteur(meters);
    // LOGGER.atInfo().log("Mètre {} envoyé au client", meters);
    // }

}
