package br.com.zask.cct.core.exception.handler;

import br.com.zask.cct.core.exception.ServiceUnavailableException;
import br.com.zask.cct.core.exception.model.Message;
import br.com.zask.cct.core.exception.model.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static java.util.Collections.singletonList;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ErrorHandler {

    private static final String CONTENT_TYPE = "Content-Type";

    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";

    private static final String ERROR = "error";

    @ExceptionHandler(ServiceUnavailableException.class)
    public HttpEntity<Message> handlerServiceUnavailableException(
            ServiceUnavailableException ex) {
        log.debug(ERROR, ex);
        Message message = new Message(MessageType.Service_Unavailable,
                MessageType.Service_Unavailable.getDescription()+" = "+ex.getServiceDetail(),
                ex.getNotifications());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders,
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    private HttpEntity<Message> handleSecurityException(Exception ex) {
        log.debug(ERROR, ex);
        Message message = new Message(MessageType.Access_Denied,
                MessageType.Access_Denied.getDescription(),
                singletonList(ex.getMessage()));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.FORBIDDEN);
    }

}