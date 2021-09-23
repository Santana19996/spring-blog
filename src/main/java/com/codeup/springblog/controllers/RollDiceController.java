package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String ViewGuessNumberPage() {
        return "GuessNumber";
    }


    @GetMapping("/roll-dice/{number}")
    @ResponseBody
    public String chooseNumber(@PathVariable int number,Model model) {

        Random r = new Random();
        int low = 1;
        int high = 6;
        int randomNumber = r.nextInt(high - low) + low;
        model.addAttribute("diceRoll", randomNumber);
        model.addAttribute("userGuess",number);
        model.addAttribute("isCorrect",randomNumber == number);
        return "You guessed " + number +"!" +
                 "<br>" + "The correct guess was the number " + randomNumber;
    }


}

