package com.example.numbers

import org.apache.commons.math3.primes.Primes.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("numbers")
class NumbersController {

    @GetMapping
    fun index(): Boolean {
        return true;
    }
    @GetMapping("pi")
    fun pi(): Double {
        return kotlin.math.PI;
    }

    @GetMapping("multiply/{param1}/{param2}")
    fun multiply(@PathVariable param1: Int, @PathVariable param2: Int): Int{
        return param1 * param2;
    }

    @GetMapping("prime/{primeNr}")
    fun prime(@PathVariable primeNr: Int): Int{
//        return isPrime(primeNr);
        return nextPrime(primeNr);
    }


}