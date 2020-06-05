package br.com.zask.cct.enviroment;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Database {

    private String host;

    private Integer port;

    private String sid;

    private String serviceName;

    private String url;

    private String owner;

    private String password;

}
