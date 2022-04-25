package com.dev4.wc7gitbingo.controllers

import com.dev4.wc7gitbingo.models.CreateCard
import com.dev4.wc7gitbingo.services.CardService
import com.dev4.wc7gitbingo.services.OptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HtmlController {
    @Autowired
    lateinit var optionService: OptionService;

    @Autowired
    lateinit var cardService: CardService;

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("createCard", CreateCard())
        return "index"
    }

    @PostMapping("/generateCard")
    fun createCard(@ModelAttribute("createCard") createCard: CreateCard, model: Model): String {
        println(createCard.name);
        println(createCard.type);
        var card = cardService.generateCard(createCard.name!!, createCard.type!!)
        println(card.values)
        model.addAttribute("values", card.values);
        model.addAttribute("card", card);
        return "bingo";
    }

    @GetMapping("/updateValue")
    fun updateValue(@RequestParam card: String, @RequestParam value: String, model: Model): String {
        println(card);
        println("Value from");
        println(value);
        model.addAttribute("createCard", CreateCard())
        return "index"
    }

}