package com.aoe.service.version.jpa;

import com.aoe.service.version.entity.Version;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by joey on 16-7-20.
 */
@Repository
public interface VersionRepository extends JpaRepository<Version,Long> {
    Version findTopByOrderByNameDesc();
}
