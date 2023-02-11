package com.zorgundostu.shelter.model.notification;

import java.util.List;

import com.vladmihalcea.hibernate.type.json.JsonType;
import com.zorgundostu.integration.domain.notification.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity(name = "Notification")
@Table(name = "notification")
public class Notification extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Enumerated(EnumType.STRING)
    private NotificationContent content;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> gsmList;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<NotificationParameter> parameterList;
}