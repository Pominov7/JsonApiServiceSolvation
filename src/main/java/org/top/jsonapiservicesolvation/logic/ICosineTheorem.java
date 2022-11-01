package org.top.jsonapiservicesolvation.logic;

import org.springframework.stereotype.Component;
import org.top.jsonapiservicesolvation.messages.InputMessage;
import org.top.jsonapiservicesolvation.messages.OutputMessage;

// интерфейс теоремы косинусов уравнений
@Component
public interface ICosineTheorem {
    // метод нахождения третьей стороны
    OutputMessage findingTheThirdLine(InputMessage input);

}
