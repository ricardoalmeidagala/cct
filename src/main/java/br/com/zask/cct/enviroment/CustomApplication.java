package br.com.zask.cct.enviroment;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomApplication {

    private String applicationId;

    private String applicationShortName;

    private String basePath;

    private String databaseOwner;

    private String databasePassword;

}
