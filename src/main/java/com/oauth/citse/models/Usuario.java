package com.oauth.citse.models;

import lombok.Data;

import java.util.List;

@Data
public class Usuario {
    private Integer idUsuario;
    private String nuUsuario;
    private String pwUsuario;
    private Boolean esUsuario;
    private List<Role> roles;
}
