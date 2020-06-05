package br.com.zask.cct.core.exception;

import br.com.zask.cct.core.exception.model.MessageType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ServiceUnavailableException extends ZaskRuntimeException{

    private String serviceDetail;

    public ServiceUnavailableException(String serviceDetail, List<String> notifications) {
        super(MessageType.Service_Unavailable, notifications,
                HttpStatus.SERVICE_UNAVAILABLE.value());
        this.serviceDetail = serviceDetail;
    }

    public ServiceUnavailableException(String serviceDetail, List<String> notifications, Throwable cause) {
        super(MessageType.Service_Unavailable, notifications, cause,
                HttpStatus.SERVICE_UNAVAILABLE.value());
        this.serviceDetail = serviceDetail;
    }

}
