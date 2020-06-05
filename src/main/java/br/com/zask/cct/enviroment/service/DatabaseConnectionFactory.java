package br.com.zask.cct.enviroment.service;

import br.com.zask.cct.core.exception.ServiceUnavailableException;
import br.com.zask.cct.enviroment.Database;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseConnectionFactory {

    public Connection getConnection(Database database) {

        Connection conn = null;
        String url = "";

        try {

            if (!StringUtils.isEmpty(database.getUrl())) {
                url = database.getUrl();
            } else {
                url = "jdbc:oracle:thin:@" + database.getHost() + ":" + database.getPort();

                if (!StringUtils.isEmpty(database.getSid())) {
                    url = url + ":" + database.getSid();
                } else {
                    url = url + "/" + database.getServiceName();
                }
            }
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            conn = DriverManager.getConnection
                    (url, database.getOwner(), database.getPassword());

        } catch (SQLException sqle) {
            List<String> notifications = new ArrayList<String>();
            notifications.add(sqle.getLocalizedMessage());
            throw new ServiceUnavailableException(url,notifications);
        }

        return conn;

    }




}
