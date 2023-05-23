package ru.neoflex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.CalcRecord;

@RestController
public class CalcController {

    @Autowired
    RecordController recordController;

    @GetMapping("/minus/{a}/{b}")
    String subtract(@PathVariable("a") float element1, @PathVariable("b") float element2) {
        String result = String.valueOf(element1 - element2);
        recordController.createRecord(
                new CalcRecord("minus", String.valueOf(element1), String.valueOf(element2), result));

        return result;
    }

    @GetMapping("/plus/{a}/{b}")
    String fold(@PathVariable("a") float element1, @PathVariable("b") float element2) {
        String result = String.valueOf(element1 + element2);
        recordController.createRecord(
                new CalcRecord("plus", String.valueOf(element1), String.valueOf(element2), result));

        return result;
    }

    @GetMapping("/multiply/{a}/{b}")
    String multiplication(@PathVariable("a") float element1, @PathVariable("b") float element2) {
        String result = String.valueOf(element1 * element2);
        recordController.createRecord(
                new CalcRecord("multiply", String.valueOf(element1), String.valueOf(element2), result));

        return result;
    }

    @GetMapping("/devide/{a}/{b}")
    String deviation(@PathVariable("a") float element1, @PathVariable("b") float element2) {
        String result = String.valueOf(element1 / element2);
        recordController.createRecord(
                new CalcRecord("devide", String.valueOf(element1), String.valueOf(element2), result));

        return result;
    }
}
