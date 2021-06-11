package com.bog.bogProject.repository;

import com.bog.bogProject.entity.User;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u " +
            "WHERE " +
            "LOWER(u.firstName) LIKE CONCAT('%',LOWER(:typed),'%') or " +
            "LOWER(u.lastName) LIKE CONCAT('%',LOWER(:typed),'%') or " +
            "LOWER(u.email) LIKE CONCAT('%',LOWER(:typed),'%') ")
    List<Object> search(@Param("typed") String typed);

}
