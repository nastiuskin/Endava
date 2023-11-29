package com.endava.springbooticek.DTO;

import com.endava.springbooticek.entity.LabelEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private String title;
    private boolean completed;
    private Set<LabelEntity> labels;
}
