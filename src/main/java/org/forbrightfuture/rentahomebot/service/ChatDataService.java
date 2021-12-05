package org.forbrightfuture.rentahomebot.service;

import org.forbrightfuture.rentahomebot.dto.telegram.update.ChatDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.MessageDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.TelegramUpdateDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.UserDTO;
import org.forbrightfuture.rentahomebot.entity.Chat;
import org.forbrightfuture.rentahomebot.entity.Message;
import org.forbrightfuture.rentahomebot.entity.User;

public interface ChatDataService {

    void saveTelegramMessage(TelegramUpdateDTO telegramUpdateDTO);

    Chat saveChat(ChatDTO chatDTO);

    Chat updateChat(Chat chat);

    User saveUser(UserDTO userDTO);

    Message saveMessage(MessageDTO messageDTO, Chat chat, User user);

    Chat getChatByChatId(Long chatId);

}
