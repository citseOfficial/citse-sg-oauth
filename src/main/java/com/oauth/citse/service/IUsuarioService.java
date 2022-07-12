package com.oauth.citse.service;

import com.oauth.citse.models.Persona;
import com.oauth.citse.models.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);

    public Persona findByNuIdentification(String numero);

}
