package br.com.cotemig.Personal.Finder.domain.trainingSheet;

import br.com.cotemig.Personal.Finder.domain.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_TRAINING_SHEET")
@Where(clause = "deleted_at IS NULl")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TrainingSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate start_date;

    private LocalDate end_date;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @ManyToOne
    private User student;

    @ManyToOne
    private User personal;

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }

}