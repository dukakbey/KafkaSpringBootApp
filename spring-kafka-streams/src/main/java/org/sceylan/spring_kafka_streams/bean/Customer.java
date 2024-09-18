package org.sceylan.spring_kafka_streams.bean;
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
    @NotBlank
    private String metaInformation;
}
