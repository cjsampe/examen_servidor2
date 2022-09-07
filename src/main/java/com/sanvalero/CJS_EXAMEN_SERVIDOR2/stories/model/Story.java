package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.model;

import com.sanvalero.CJS_EXAMEN_SERVIDOR2.shared.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data()
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Story extends BaseModel {
    @Column
    private String title;
    @Column
    private String description;
    @Column(length = 1337)
    private String text;
    @Column
    private String category;
    @Column (name = "number_letters")
    private  int numberLetters;
    @Column (name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creationDate;
}
