package com.canevim.shelter.repository;

import java.util.UUID;

import com.canevim.shelter.model.request.Requester;
import com.canevim.shelter.model.statistics.StatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RequesterRepository extends JpaRepository<Requester, Long> {

    Page<Requester> findAll(Pageable pageable);
    @Query(value = "SELECT requester AS type, COALESCE(COUNT(DISTINCT r.identity_number),0) AS person, COALESCE(SUM(r.adult_number+r.child_number),0) AS capacity  FROM requesters r",nativeQuery = true)
    StatisticDto findRequesterStatistics();

    @Modifying
    @Query("UPDATE requesters SET status = :status WHERE id = :id ")
    boolean updateStatus(UUID id, String status);
}
