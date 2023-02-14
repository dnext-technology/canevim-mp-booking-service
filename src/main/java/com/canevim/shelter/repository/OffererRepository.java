package com.canevim.shelter.repository;

import java.util.UUID;

import com.canevim.shelter.model.offer.Offerer;
import com.canevim.shelter.model.statistics.StatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffererRepository extends JpaRepository<Offerer, Long> {
    Page<Offerer> findAll(Pageable pageable);
    @Query(value = "SELECT offerers as type, COALESCE(COUNT(DISTINCT o.identity_number),0) as person , COALESCE(SUM(o.guest_capacity),0) as capacity FROM offerers o", nativeQuery = true)
    StatisticDto findOffererStatistics();

    @Modifying
    @Query(value = "UPDATE offerers SET status = :status WHERE id = :id ",nativeQuery = true)
    boolean updateStatus(UUID id, String status);
}
