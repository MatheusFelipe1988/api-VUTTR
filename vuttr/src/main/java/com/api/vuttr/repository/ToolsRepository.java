package com.api.vuttr.repository;

import com.api.vuttr.domain.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {
    @Query(value = "select * from tools where tags like %:tag%", nativeQuery = true)
    List<Tools> findByTags(@Param("tag") String tag);
}
