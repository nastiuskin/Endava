package com.endava.springbooticek.repository;

import com.endava.springbooticek.entity.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepo extends JpaRepository<LabelEntity, Long> {
    LabelEntity getLabelEntityByTitle(String title);
}
