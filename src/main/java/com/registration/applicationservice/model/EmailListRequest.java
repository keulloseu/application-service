package com.registration.applicationservice.model;

import com.registration.applicationservice.dto.EmailDto;
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
