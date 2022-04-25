package com.dev4.wc7gitbingo.services

import com.dev4.wc7gitbingo.models.Option
import com.dev4.wc7gitbingo.repositories.OptionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OptionService {
    @Autowired
    lateinit var repository: OptionRepository;

    fun getAllOptions(): List<Option> {
        return repository.findAll();
    }

    fun saveOption(option: Option): Option {
        return repository.save(option);
    }
}