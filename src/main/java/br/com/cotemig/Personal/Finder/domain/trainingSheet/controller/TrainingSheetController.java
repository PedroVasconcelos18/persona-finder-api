package br.com.cotemig.Personal.Finder.domain.trainingSheet.controller;

import br.com.cotemig.Personal.Finder.domain.trainingSheet.service.TrainingSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training-sheet")
@RequiredArgsConstructor
public class TrainingSheetController {

    @GetMapping
    public ResponseEntity<String> getAllTrainingSheets() {
        return ResponseEntity.ok("Hello");
    }

}
