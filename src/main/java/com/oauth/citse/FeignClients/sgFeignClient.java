package com.oauth.citse.FeignClients;

import com.oauth.citse.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "citse-ms-sg")
public interface sgFeignClient {

    @GetMapping("/usuarios/search/identificacion")
    public Usuario getUsuario(@RequestParam(name = "numero") String nuUsuario);
}
