package com.dev4.wc7gitbingo.controllers

import com.dev4.wc7gitbingo.models.Option
import com.dev4.wc7gitbingo.services.OptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class RestController {

    @Autowired
    lateinit var optionService: OptionService

    @GetMapping("options")
    fun getOptions(): List<Option> {
        return optionService.getAllOptions()
    }

    @PostMapping("addOptions")
    fun addOptions(@RequestBody optionList: List<String>): List<Option> {
        var options: MutableList<Option> = mutableListOf()
        for (optionString in optionList) {
            println(optionString);
            options.add(optionService.saveOption(Option(content = optionString)))
        }

        return options
    }
}