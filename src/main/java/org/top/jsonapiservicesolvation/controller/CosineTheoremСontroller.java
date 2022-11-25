package org.top.jsonapiservicesolvation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.top.jsonapiservicesolvation.logic.ICosineTheorem;
import org.top.jsonapiservicesolvation.messages.*;

@Controller                                // REST-контроллер
@RequestMapping("/service")
public class CosineTheoremСontroller {
    @Autowired
    private ICosineTheorem solution;  // объект интерфейс класса теорема косинусов

    // 1. ping
    @GetMapping("/ping")
    public @ResponseBody Messages ping() {
        return new Messages("pong");
    }

    // 2. статус сервера
    @GetMapping("/status")
    public @ResponseBody Messages status() {
        return new Messages("Server status on port 8080: OK ");
    }

    // 3. решение
    @PostMapping("/solve")
    public @ResponseBody IMessage solve(@RequestBody InputMessage input) {
        System.out.println("Полученные данные: " + input);
        OutputMessage out = solution.findingTheThirdLine(input);
        if (out == null) {
            return new ErrorMessage("The number cannot be negative or equal to zero");
        }
        return out;
    }

}

