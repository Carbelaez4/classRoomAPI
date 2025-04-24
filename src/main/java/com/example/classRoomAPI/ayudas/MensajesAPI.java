package com.example.classRoomAPI.ayudas;

public enum MensajesAPI {
    ERROR_DOCENTE_NO_ENCONTRADO("El docente que buscas, no esta en la BD"),
    ERROR_ASISTENCIA_NO_ENCONTRADO("La asistencia no esta, perro!!!"),
    ERROR_CALIFICACION_NO_ENCONTRADA("La calificacion no fue encontrada"),
    ERROR_CURSO_NO_ENCONTRADO("El curso no fue encontrado"),
    ERROR_ESTUDIANTE_NO_ENCONTRADO("El estudiante no fue encontrado"),
    ERROR_INSCRIPCION_NO_ENCONTRADO("La inscripcion no fue encontrada"),
    ERROR_MATERIA_NO_ENCONTRADOA("La materia no fue encontrada"),
    ERROR_USUARIO_NO_ENCONTRADOA("El usuario no fue encontrado")

;
    private String mensaje;

    MensajesAPI(String mensaje) {
        this.mensaje=mensaje;
    }
    public String getMensaje(){
        return mensaje;
    }
}
