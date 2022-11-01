package org.top.jsonapiservicesolvation.logic;

import org.junit.jupiter.api.Test;
import org.top.jsonapiservicesolvation.messages.InputMessage;

class CosineTheoremTest {

    @Test
    void findingTheThirdLine() {
        InputMessage date = new InputMessage(2, 2, 20); // входные данные
        CosineTheorem solve = new CosineTheorem(); // создание объекта класса теоремы косинуса
        System.out.println(solve.findingTheThirdLine(date)); // вывод в консоль результата решения
    }
}