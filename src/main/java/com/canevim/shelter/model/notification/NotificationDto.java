package com.canevim.shelter.model.notification;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public record NotificationDto(
        @NotNull NotificationType type,
        @NotNull NotificationContent content,
        @NotNull List<String> gsmList,
        List<NotificationParameter> parameterList
) {
    public String getParameterValueByKey(String key) {
        return this.parameterList().stream().filter(notificationParameter -> notificationParameter.getKey().equals(key)).findFirst().orElseThrow(() -> new IllegalArgumentException("Parameter is not found with key:" + key)).getValue();
    }

    public void addParameter(String key, String value) {
        if (!isKeyExist(key)) {
            var notificationParameter = new NotificationParameter();
            notificationParameter.setKey(key);
            notificationParameter.setValue(value);
            this.parameterList().add(notificationParameter);
        } else {
            this.parameterList().stream().filter(notificationParameter -> notificationParameter.getKey().equals(key)).findFirst().orElseThrow(() -> new IllegalArgumentException("Parameter is not found with key:" + key)).setValue(value);
        }
    }

    private boolean isKeyExist(String key) {
        return this.parameterList().stream().anyMatch(notificationParameter -> notificationParameter.getKey().equals(key));
    }
}
