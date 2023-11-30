package com.endava.springbooticek.DTO;

import com.endava.springbooticek.entity.LabelEntity;
import com.endava.springbooticek.entity.UserEntity;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private String title;
    private Set<String> labels;
}
