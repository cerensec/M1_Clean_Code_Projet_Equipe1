package com.api.veloconnecte;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.api.veloconnecte.serivce.ICapteurService;
import com.api.veloconnecte.serivce.IDistanceFromWheelService;
import model.poc.ICapteur;
import model.poc.IWheel;
import model.poc.impl.CapteurPoc;
import model.poc.impl.WheelPoc;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableScheduling
public class VeloconnecteApplication {
    private static final Logger LOGGER = LogManager.getLogger(VeloconnecteApplication.class);

    @Autowired
    private IDistanceFromWheelService<IWheel> distanceFromWheelService;
    @Autowired
    private ICapteurService capteurService;

    private ICapteur capteurPoc = new CapteurPoc();

    IWheel WheelMichelen = new WheelPoc("Michelin");

    public static void main(String[] args) {
        SpringApplication.run(VeloconnecteApplication.class, args);
    }

    @Scheduled(fixedRate = 1000)
    public void readerDataFromCapture() {
        double meters = distanceFromWheelService.calculateDistanceInMeters(WheelMichelen,
                                                                           capteurPoc.getNomberRatation());

        capteurService.sendDistanceFromCapteur(meters);
        LOGGER.atInfo().log("Mètre {} envoyé au client", meters);
    }

}
