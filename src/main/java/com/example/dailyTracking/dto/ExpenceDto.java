package com.example.dailyTracking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * This class use for ignoring "Replace this persistent entity with a simple POJO or DTO object" issue in sonarqube.
 */
import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ExpenceDto implements Serializable {

    private String name;
    private String category;
    private String amount;
    private String date;
}
