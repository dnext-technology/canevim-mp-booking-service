package com.zorgundostu.shelter.service;

import java.util.List;
import java.util.Map;

import com.zorgundostu.shelter.client.ShelterHttpClient;
import com.zorgundostu.shelter.model.notification.Notification;
import com.zorgundostu.shelter.model.notification.NotificationContent;
import com.zorgundostu.shelter.model.notification.NotificationDto;
import com.zorgundostu.shelter.model.notification.NotificationParameter;
import com.zorgundostu.shelter.model.notification.NotificationType;
import com.zorgundostu.shelter.model.provider.Offerer;
import com.zorgundostu.shelter.model.provider.OffererDto;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AsyncTaskService {

    private final String integrationUrl;
    private final ShelterHttpClient shelterHttpClient;

    public AsyncTaskService(@Value("${endpoints.integration}") String integrationUrl, ShelterHttpClient shelterHttpClient){
        this.integrationUrl = integrationUrl;
        this.shelterHttpClient = shelterHttpClient;
    }

    @Async
    public void callForNotifyingMinistry(Map<String, String> header, OffererDto offererDto){
        var response = shelterHttpClient.doPost(integrationUrl,header,offererDto, Boolean.class);
        if(response){
            log.info("The ministry is informed for {}", offererDto.id());
        }else{
            log.error("The ministry is not informed for {}", offererDto.id());
        }
    }

    @Async
    public void sendNotification(Map<String, String> header,String firstName, String lastName, String phone, String code){
        NotificationParameter nameParameter = new NotificationParameter();
        nameParameter.setKey("name");
        nameParameter.setValue(firstName+" "+lastName);
        NotificationParameter codeParameter = new NotificationParameter();
        codeParameter.setKey("name");
        codeParameter.setValue(code);

        NotificationDto notificationDto = new NotificationDto(NotificationType.SMS, NotificationContent.WELCOME, List.of(phone), List.of(nameParameter, codeParameter));
        try {
            shelterHttpClient.doPost(integrationUrl, header,notificationDto, Void.class);
        }catch (Exception exception){
            log.error("The welcome sms has not been sent to {}", phone);
        }

    }
}
