package com.endava.springbooticek.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date date;

    private Boolean completed;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}
, fetch = FetchType.EAGER)
    @JoinTable(
            name = "task_label",
            joinColumns = @JoinColumn(name = "task_id"),
            foreignKey = @ForeignKey(name = "fk_task_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"),
            inverseForeignKey = @ForeignKey(name = "fk_label_id")
    )
    private Set<LabelEntity> labels = new HashSet<>();
}
