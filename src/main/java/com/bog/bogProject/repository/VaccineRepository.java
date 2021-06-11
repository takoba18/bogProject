package com.bog.bogProject.repository;


import com.bog.bogProject.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    @Query("select v from Vaccine v where LOWER( v.name) like CONCAT('%',LOWER( :name),'%')")
    Vaccine findByName(@Param("name") String name);

    @Query(value = "SELECT v FROM Vaccine v " +
            "WHERE " +
            "LOWER(v.name) LIKE CONCAT('%',LOWER(:typed),'%') or " +
            "LOWER(v.company) LIKE CONCAT('%',LOWER(:typed),'%') ")
    List<Object> search(@Param("typed") String typed);
}
