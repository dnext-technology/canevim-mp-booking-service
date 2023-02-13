package com.canevim.shelter.repository;

import java.util.UUID;

import com.canevim.shelter.model.request.Requester;
import com.canevim.shelter.model.statistics.StatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequesterRepository extends CrudRepository<Requester, Long> {

    Page<Requester> findAll(Pageable pageable);
    @Query("""
                 SELECT 'requester' AS "type", COALESCE(COUNT(DISTINCT r.identity_number),0) AS "person", COALESCE(SUM(r.adult_number+r.child_number),0) AS "capacity"  FROM requesters r
            """)
    StatisticDto findRequesterStatistics();

    @Modifying
    @Query("UPDATE requesters SET status = :status WHERE id = :id ")
    boolean updateStatus(UUID id, String status);
}
