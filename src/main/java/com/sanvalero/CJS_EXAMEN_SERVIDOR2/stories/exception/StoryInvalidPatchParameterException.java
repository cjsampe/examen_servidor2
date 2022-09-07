package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.exception;

public class StoryInvalidPatchParameterException extends RuntimeException{

    public StoryInvalidPatchParameterException(){
        super();
    }

    public StoryInvalidPatchParameterException(String Key){
        super(String.format("Parámetro '%s' para actualizar en ralto corto desconocido"));
    }
}
