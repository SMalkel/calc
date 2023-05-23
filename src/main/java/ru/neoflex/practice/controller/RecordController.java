package ru.neoflex.practice.controller;

import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.practice.CalcRecord;
import ru.neoflex.practice.RecordRepository;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/db_api")
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("/records")
    public List<CalcRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    @GetMapping("/records/{id}")
    public ResponseEntity<CalcRecord> getRecordById(@PathVariable(value = "id") Long recordId)
            throws InvalidConfigurationPropertyValueException {
        CalcRecord record = recordRepository.findById(recordId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("id_" + recordId,
                        recordId, "Record not found for this id :: " + recordId));
        return ResponseEntity.ok().body(record);
    }

    @PostMapping("/records")
    public CalcRecord createRecord(@Valid @RequestBody CalcRecord record) {
        return recordRepository.save(record);
    }

    @PutMapping("/records/{id}")
    public ResponseEntity<CalcRecord> updateRecord(@PathVariable(value = "id") Long recordId,
                                                   @Valid @RequestBody CalcRecord recordDetails)
            throws InvalidConfigurationPropertyValueException {
        CalcRecord record = recordRepository.findById(recordId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("id_" + recordId,
                        recordId, "Record not found for this id :: " + recordId));

        record.setOperation(recordDetails.getOperation());
        record.setFirstNumber(recordDetails.getFirstNumber());
        record.setSecondNumber(recordDetails.getSecondNumber());
        record.setResult(recordDetails.getResult());

        final CalcRecord updatedRecord = recordRepository.save(record);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/records/{id}")
    public Map<String, Boolean> deleteRecord(@PathVariable(value = "id") Long recordId)
            throws InvalidConfigurationPropertyValueException {
        CalcRecord record = recordRepository.findById(recordId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("id_" + recordId,
                        recordId, "Record not found for this id :: " + recordId));

        recordRepository.delete(record);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
