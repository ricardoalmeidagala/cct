package br.com.zask.cct.enviroment.service;

import br.com.zask.cct.core.exception.ServiceUnavailableException;
import br.com.zask.cct.enviroment.Database;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

@Component
@AllArgsConstructor
public class EnviromentService {

    private final DatabaseConnectionFactory databaseConnectionFactory;

    public Database validateDatabase(Database database){

        try {
            databaseConnectionFactory.getConnection(database).close();
        } catch (SQLException sqle) {
            List<String> notifications = new ArrayList<String>();
            notifications.add(sqle.getLocalizedMessage());
            throw new ServiceUnavailableException("closing database",notifications);
        }

        return database;

    }

}
