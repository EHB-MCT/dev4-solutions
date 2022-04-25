package com.dev4.wc7gitbingo.services

import com.dev4.wc7gitbingo.models.Card
import com.dev4.wc7gitbingo.models.Value
import com.dev4.wc7gitbingo.repositories.CardRepository
import com.dev4.wc7gitbingo.repositories.OptionRepository
import com.dev4.wc7gitbingo.repositories.ValueRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class CardService {
    @Autowired
    lateinit var cardRepository: CardRepository;
    @Autowired
    lateinit var optionRepository: OptionRepository;
    @Autowired
    lateinit var valueRepository: ValueRepository;

    fun generateCard(name: String, type: String): Card {
        var card = cardRepository.save(Card(name = name));
        //get all options
        val options = optionRepository.findAll();
        options.shuffle();

        if(options.size >= 16) {
            var values = mutableListOf<Value>();
            for(i in 0..15) {
                var option = options[i];
                var value = Value(position = i, content = option.content);
                value.card = card;
                values.add(valueRepository.save(value));
                println(i);
            }
            card.values = values
            return card;
        } else {
            return error("Not enough options to generate card");
        }
    }

}