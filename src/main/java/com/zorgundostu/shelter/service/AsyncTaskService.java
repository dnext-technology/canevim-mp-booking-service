package com.zorgundostu.shelter.service;

import java.util.List;
import java.util.Map;

import com.zorgundostu.shelter.client.ShelterHttpClient;
import com.zorgundostu.shelter.client.ShelterHttpUtils;
import com.zorgundostu.shelter.model.ministry.ShelterMinistryResponse;
import com.zorgundostu.shelter.model.notification.NotificationContent;
import com.zorgundostu.shelter.model.notification.NotificationDto;
import com.zorgundostu.shelter.model.notification.NotificationParameter;
import com.zorgundostu.shelter.model.notification.NotificationType;
import com.zorgundostu.shelter.model.offer.Offerer;
import com.zorgundostu.shelter.service.util.ShelterUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class AsyncTaskService {

    private final String shelterUrl;
    private final String notificationUrl;
    private final ShelterHttpClient shelterHttpClient;

    public AsyncTaskService(@Value("${endpoints.integration.shelter}") String shelterUrl,@Value("${endpoints.integration.notification}") String notificationUrl, ShelterHttpClient shelterHttpClient) {
        this.shelterUrl = shelterUrl;
        this.notificationUrl = notificationUrl;
        this.shelterHttpClient = shelterHttpClient;
    }

    //TODO Async not implemented yet

    public void callForNotifyingMinistry(Offerer offerer) {
        var request = ShelterUtils.generateShelterObjectToSendMinistry(offerer);
        var response = shelterHttpClient.doPost(shelterUrl, ShelterHttpUtils.generateHttpDefaultHeader(), request, ShelterMinistryResponse.class);
        if (ObjectUtils.isEmpty(response) || !response.IslemBasarilimi()) {
            log.error("The ministry has not been informed for {}", offerer.getId());
        } else {
            log.info("The ministry is informed for {}", offerer.getId());
        }
    }

    public void sendNotification(String firstName, String lastName, String phone, String code) {
        NotificationParameter nameParameter = new NotificationParameter();
        nameParameter.setKey("name");
        nameParameter.setValue(firstName + " " + lastName);
        NotificationParameter codeParameter = new NotificationParameter();
        codeParameter.setKey("name");
        codeParameter.setValue(code);

        NotificationDto notificationDto = new NotificationDto(NotificationType.SMS, NotificationContent.WELCOME, List.of(phone), List.of(nameParameter, codeParameter));
        try {
          var response =  shelterHttpClient.doPost(notificationUrl, ShelterHttpUtils.generateHttpDefaultHeader(), notificationDto, NotificationDto.class);
            System.out.println(response);
        } catch (Exception exception) {
            log.error("The welcome sms has not been sent to {}", phone);
        }

    }
}
