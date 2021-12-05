package org.forbrightfuture.rentahomebot.schedule;

import lombok.extern.slf4j.Slf4j;
import org.forbrightfuture.rentahomebot.dto.telegram.update.TelegramUpdateDTO;
import org.forbrightfuture.rentahomebot.entity.Home;
import org.forbrightfuture.rentahomebot.service.CityService;
import org.forbrightfuture.rentahomebot.service.HomeService;
import org.forbrightfuture.rentahomebot.service.TelegramMessagingService;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@EnableAsync
@Slf4j
public class BotSchedule {

    private final CityService cityService;
    private final HomeService homeService;
    private final TelegramMessagingService telegramMessagingService;

    public BotSchedule(CityService cityService, HomeService homeService,
                       TelegramMessagingService telegramMessagingService) {
        this.cityService = cityService;
        this.homeService = homeService;
        this.telegramMessagingService = telegramMessagingService;
    }

    @Scheduled(fixedRateString = "${task.update-cities.rate}")
    public void updateCities() throws IOException {
        log.info("City table update began");
        long startTime = System.currentTimeMillis();
        cityService.updateCities();
        long endTime = System.currentTimeMillis();
        log.info("City table update stopped");
        log.info("Passed time for city table update: " + (endTime - startTime) + " ms");
    }

    @Scheduled(fixedDelayString = "${task.update-homes.rate}", initialDelay = 10000L)
    public void updateHomes() throws IOException {
        log.info("Homes update began");
        long startTime = System.currentTimeMillis();
        homeService.findNewHomes();
        long endTime = System.currentTimeMillis();
        log.info("Homes update stopped");
        log.info("Passed time for home table update: " + (endTime - startTime) + " ms");
    }

    @Scheduled(fixedRateString = "${task.update-telegram-update.rate}")
    public void getTelegramUpdates() {
        TelegramUpdateDTO telegramUpdateDTO = telegramMessagingService.getUpdates();
        if (telegramUpdateDTO != null) {
            log.info(telegramUpdateDTO.toString());
            telegramMessagingService.reply(telegramUpdateDTO);
        }
    }

    @Scheduled(fixedDelayString = "${task.send-new-notification.rate}")
    public void sendNotificationsToUsers() {
        List<Home> homeList = homeService.getUnsentHomes();
        telegramMessagingService.sendNewNotifications(homeList);
    }

}
