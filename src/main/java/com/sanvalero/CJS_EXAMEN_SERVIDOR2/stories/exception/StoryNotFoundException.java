package com.sanvalero.CJS_EXAMEN_SERVIDOR2.stories.exception;

public class StoryNotFoundException extends RuntimeException {

    public StoryNotFoundException(){
        super();
    }

    public StoryNotFoundException(String message){
        super(message);

    }

    public StoryNotFoundException(long id){
        super("Error al buscar la información del relato corto por el ID: " + id);
    }


}
