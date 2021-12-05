package org.forbrightfuture.rentahomebot.service.impl;

import org.forbrightfuture.rentahomebot.constant.ChatStage;
import org.forbrightfuture.rentahomebot.dto.telegram.update.ChatDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.MessageDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.TelegramUpdateDTO;
import org.forbrightfuture.rentahomebot.dto.telegram.update.UserDTO;
import org.forbrightfuture.rentahomebot.entity.Chat;
import org.forbrightfuture.rentahomebot.entity.Message;
import org.forbrightfuture.rentahomebot.entity.User;
import org.forbrightfuture.rentahomebot.repository.ChatRepository;
import org.forbrightfuture.rentahomebot.repository.MessageRepository;
import org.forbrightfuture.rentahomebot.repository.UserRepository;
import org.forbrightfuture.rentahomebot.service.ChatDataService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatDataServiceImpl implements ChatDataService {

    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatDataServiceImpl(MessageRepository messageRepository,
                               ChatRepository chatRepository,
                               UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveTelegramMessage(TelegramUpdateDTO telegramUpdateDTO) {
        Chat chat = saveChat(telegramUpdateDTO.getMessageDTO().getChat());
        User user = saveUser(telegramUpdateDTO.getMessageDTO().getFrom());
        Message message = saveMessage(telegramUpdateDTO.getMessageDTO(), chat, user);
    }

    @Override
    public Chat saveChat(ChatDTO chatDTO) {
        Long chatId = chatDTO.getId();
        Chat chat = chatRepository.getChatByChatId(chatId);
        if (chat == null) {
            chat = new Chat();
            chat.setChatId(chatDTO.getId());
            chat.setFirstName(chatDTO.getFirstName());
            chat.setLastName(chatDTO.getLastName());
            chat.setTitle(chatDTO.getTitle());
            chat.setType(chatDTO.getType());
            chat.setUsername(chatDTO.getUsername());
            chat.setChatStage(ChatStage.START);
            chat.setBio(chatDTO.getBio());
            chat.setDescription(chatDTO.getDescription());
            chat = chatRepository.save(chat);
        }
        return chat;
    }

    @Override
    public Chat updateChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public User saveUser(UserDTO userDTO) {
        Long userId = userDTO.getId();
        User user = userRepository.getUserById(userId);
        if (user == null) {
            user = new User();
            user.setId(userDTO.getId());
            user.setIsBot(userDTO.getIsBot());
            user.setUsername(userDTO.getUsername());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setLanguageCode(userDTO.getLanguageCode());
            user = userRepository.save(user);
        }
        return user;
    }

    @Override
    public Message saveMessage(MessageDTO messageDTO, Chat chat, User user) {
        Message message = new Message();
        message.setMessageId(messageDTO.getMessageId());
        message.setDate(new Date(messageDTO.getDate()));
        message.setText(messageDTO.getText());
        message.setChat(chat);
        message.setUser(user);
        message = messageRepository.save(message);
        return message;
    }

    @Override
    public Chat getChatByChatId(Long chatId) {
        return chatRepository.getChatByChatId(chatId);
    }
}
