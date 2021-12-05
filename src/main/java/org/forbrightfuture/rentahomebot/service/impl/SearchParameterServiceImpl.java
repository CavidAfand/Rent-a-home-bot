package org.forbrightfuture.rentahomebot.service.impl;

import org.forbrightfuture.rentahomebot.entity.Chat;
import org.forbrightfuture.rentahomebot.entity.Home;
import org.forbrightfuture.rentahomebot.entity.SearchParameter;
import org.forbrightfuture.rentahomebot.repository.SearchParameterRepository;
import org.forbrightfuture.rentahomebot.service.SearchParameterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchParameterServiceImpl implements SearchParameterService {

    private final SearchParameterRepository searchParameterRepository;

    public SearchParameterServiceImpl(SearchParameterRepository searchParameterRepository) {
        this.searchParameterRepository = searchParameterRepository;
    }

    @Override
    public SearchParameter getSearchParameter(Long chatId) {
        return searchParameterRepository.getSearchParameterByChatId(chatId);
    }

    @Override
    public SearchParameter saveSearchParameter(SearchParameter searchParameter) {
        return searchParameterRepository.save(searchParameter);
    }

    @Override
    public SearchParameter updateSearchParameter(SearchParameter searchParameter) {
        return searchParameterRepository.save(searchParameter);
    }

    @Override
    public void deleteSearchParameter(Long chatId) {
        SearchParameter searchParameter = searchParameterRepository.getSearchParameterByChatId(chatId);
        if (searchParameter != null)
            searchParameterRepository.delete(searchParameter);
    }

    @Override
    public List<Chat> getChatListByAppropriateParameters(Home home) {
        return searchParameterRepository.getChatListBySearchParameters(home.getCity(), home.getPrice(), home.getNumberOfRoom());
    }
}
