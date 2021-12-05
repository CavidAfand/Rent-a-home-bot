package org.forbrightfuture.rentahomebot.service;

import org.forbrightfuture.rentahomebot.dto.telegram.send.photo.SendPhotoDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.send.text.SendMessageDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.send.SendMessageResponseDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.TelegramUpdateDTO;
import org.forbrightfuture.rentahomebot.entity.Home;

import java.util.List;

public interface TelegramMessagingService {

    TelegramUpdateDTO getUpdates();

    SendMessageResponseDTO sendMessage(SendMessageDTO sendMessageDTO);

    SendMessageResponseDTO sendPhoto(SendPhotoDTO sendPhotoDTO);

    SendMessageResponseDTO reply(TelegramUpdateDTO telegramUpdateDTO);

    void sendNewNotifications(List<Home> homeList);

}
