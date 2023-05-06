package br.com.cotemig.Personal.Finder.domain.trainingSheet.repository;

import br.com.cotemig.Personal.Finder.domain.trainingSheet.TrainingSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingSheetRepository extends JpaRepository<TrainingSheet, UUID> {

}
