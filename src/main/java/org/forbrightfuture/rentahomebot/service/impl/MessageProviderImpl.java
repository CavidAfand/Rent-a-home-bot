package org.forbrightfuture.rentahomebot.service.impl;

import org.forbrightfuture.rentahomebot.constant.Language;
import org.forbrightfuture.rentahomebot.service.MessageProvider;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class MessageProviderImpl implements MessageProvider {

    private final MessageSource messageSource;

    public MessageProviderImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String message, Language language) {
        String langName = "null";
        if (language != null)
            langName = language.name();
        return messageSource.getMessage(message, null, new Locale(langName));
    }

}
