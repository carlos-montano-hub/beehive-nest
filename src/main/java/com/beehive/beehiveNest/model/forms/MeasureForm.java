package com.beehive.beehiveNest.model.forms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MeasureForm {
    private LocalDateTime time;
    private long beehiveId;
    private double temperature;
    private double humidity;
    private double weight;
    private String audioRecordingUrl;
}
