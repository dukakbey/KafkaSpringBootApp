package org.sceylan.kafka_data_sender.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    @NotNull
    private Integer id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private Long timestamp;
    private String metaInformation;
}
