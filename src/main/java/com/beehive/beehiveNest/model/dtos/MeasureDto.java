package com.beehive.beehiveNest.model.dtos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class MeasureDto {
    private Long id;
    private LocalDateTime time;
    private Long beehiveId;
    private double temperature;
    private double humidity;
    private double weight;
    private String audioRecordingUrl;
}
