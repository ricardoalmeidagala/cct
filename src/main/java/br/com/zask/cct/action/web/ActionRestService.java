package br.com.zask.cct.action.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ActionRestService {

    @PostMapping("/v1/executeAction/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public void executeAction(@PathVariable Integer id){



    }


}
