package org.forbrightfuture.rentahomebot.service;

import org.forbrightfuture.rentahomebot.entity.Chat;
import org.forbrightfuture.rentahomebot.entity.Home;
import org.forbrightfuture.rentahomebot.entity.SearchParameter;

import java.util.List;

public interface SearchParameterService {

    SearchParameter getSearchParameter(Long chatId);

    SearchParameter saveSearchParameter(SearchParameter searchParameter);

    SearchParameter updateSearchParameter(SearchParameter searchParameter);

    void deleteSearchParameter(Long chatId);

    List<Chat> getChatListByAppropriateParameters(Home home);

}
