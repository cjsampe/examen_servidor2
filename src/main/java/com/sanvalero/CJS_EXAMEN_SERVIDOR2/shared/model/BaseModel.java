package com.sanvalero.CJS_EXAMEN_SERVIDOR2.shared.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
}
