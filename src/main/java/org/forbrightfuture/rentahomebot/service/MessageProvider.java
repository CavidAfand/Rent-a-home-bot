package org.forbrightfuture.rentahomebot.service;

import org.forbrightfuture.rentahomebot.constant.Language;

public interface MessageProvider {

    String getMessage(String message, Language lang);

}
