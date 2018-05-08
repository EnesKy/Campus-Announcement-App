package com.bilalekrem.campusannouncementwebservice.repository;

import com.bilalekrem.campusannouncementwebservice.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    @Query("SELECT a FROM Announcement a JOIN a.departments d WHERE d.id in (:deptID)")
    Optional<List<Announcement>> findByDepId(@Param("deptID") int deptID);


}
