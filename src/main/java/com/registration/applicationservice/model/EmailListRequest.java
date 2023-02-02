package com.registration.applicationservice.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailListRequest {
    private List<Long> userIds;
}
