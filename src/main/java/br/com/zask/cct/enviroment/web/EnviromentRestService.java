package br.com.zask.cct.enviroment.web;

import br.com.zask.cct.core.exception.ServiceUnavailableException;
import br.com.zask.cct.enviroment.Database;
import br.com.zask.cct.enviroment.Enviroment;
import br.com.zask.cct.enviroment.service.EnviromentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class EnviromentRestService {

    private final EnviromentService enviromentService;

    @Async
    public void startSaveEnviroment(){
        System.out.println("ASYNC METHOD");
    }

    @GetMapping("/getStatus")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public String getStatus(){
        return "OK";
    }


    @PostMapping("/validateDatabaseConnection")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public Database validateDatabaseConnection(@RequestBody Database database){

        return enviromentService.validateDatabase(database);
    }

}
