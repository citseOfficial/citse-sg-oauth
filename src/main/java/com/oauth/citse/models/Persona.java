package com.oauth.citse.models;

import lombok.Data;

@Data
public class Persona {
    private Integer idPersona;
    private String noPersona;
    private String apPaterno;
    private String apMaterno;
    private String nuIndentificacion;
    private String feNacimiento;
    private Boolean esPersona;
    private Integer idTiIndentificacion;
    private Integer idTiPersona;
    private Integer idTiEsCivil;
}
