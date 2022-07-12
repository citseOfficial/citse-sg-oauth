package com.oauth.citse.FeignClients;

import com.oauth.citse.models.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "citse-ms-maestra")
public interface MaestraFeignClient {

    @GetMapping("persona/dni/{dni}")
    public Persona getPersona(@PathVariable String dni);
}
