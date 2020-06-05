package br.com.zask.cct.core.exception;

import br.com.zask.cct.core.exception.model.MessageType;

import java.util.List;

public class ZaskRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<String> notifications;

    private MessageType messageType;

    private Integer errorCode;

    public ZaskRuntimeException() {
    }

    public ZaskRuntimeException(MessageType messageType, List<String> notifications,
                                  Integer errorCode) {
        super(new Throwable(notifications.toString()));
        this.messageType = messageType;
        this.notifications = notifications;
        this.errorCode = errorCode;
    }

    public ZaskRuntimeException(MessageType messageType, List<String> notifications,
                                  Throwable cause, Integer errorCode) {
        super(cause);
        this.messageType = messageType;
        this.notifications = notifications;
        this.errorCode = errorCode;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public int getHttpErrorCode() {
        return errorCode;
    }

}
