package com.canevim.shelter.service;

import java.util.List;

import com.canevim.shelter.service.util.ShelterUtils;
import com.canevim.shelter.client.ShelterHttpClient;
import com.canevim.shelter.client.ShelterHttpUtils;
import com.canevim.shelter.model.ministry.ShelterMinistryResponse;
import com.canevim.shelter.model.notification.NotificationContent;
import com.canevim.shelter.model.notification.NotificationDto;
import com.canevim.shelter.model.notification.NotificationParameter;
import com.canevim.shelter.model.notification.NotificationType;
import com.canevim.shelter.model.offer.Offerer;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
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
