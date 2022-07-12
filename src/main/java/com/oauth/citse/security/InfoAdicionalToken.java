package com.oauth.citse.security;

import com.oauth.citse.models.Persona;
import com.oauth.citse.models.Usuario;
import com.oauth.citse.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private IUsuarioService service;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String,Object> info = new HashMap<>();
        Usuario usuario = service.findByUsername(oAuth2Authentication.getName());
        Persona persona = service.findByNuIdentification(usuario.getNuUsuario());
        info.put("numero",usuario.getNuUsuario());
        info.put("estado",usuario.getEsUsuario());
        info.put("nombre",persona.getNoPersona());
        info.put("apellidos",persona.getApPaterno()+" "+persona.getApMaterno());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        //recibiendo datos del ms maestra para la clase persona
        System.out.println("nombre"+persona.getNoPersona());
        return oAuth2AccessToken;
    }
}
