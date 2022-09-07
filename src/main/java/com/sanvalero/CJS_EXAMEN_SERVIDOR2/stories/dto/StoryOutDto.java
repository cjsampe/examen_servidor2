package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.dto;

import com.sanvalero.CJS_EXAMEN_SERVIDOR2.shared.dto.BaseOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryOutDto extends BaseOutDto {
    String title;
    String description;
    String text;
    String category;
    int numberLetters;
    LocalDateTime creationDate;
}
