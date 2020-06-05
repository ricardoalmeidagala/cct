package br.com.zask.cct.enviroment;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enviroment {

    private Integer id;

    private String companyShortName;

    private String enviromentName;

    private String databaseHost;

    private String databasePort;

    private String databaseServiceName;

    private String databaseSID;

    private String databaseUrl;

    private String databaseAppsPassword;

    private String applicationHost;

    private String applicationPort;

    private String applicationUsername;

    private String applicationPassword;

    private List<CustomApplication> customApplications;

}
