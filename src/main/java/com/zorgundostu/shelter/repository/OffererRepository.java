package com.zorgundostu.shelter.repository;

import java.util.UUID;

import com.zorgundostu.shelter.model.offer.Offerer;
import com.zorgundostu.shelter.model.statistics.StatisticDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffererRepository extends CrudRepository<Offerer, Long> {
    Page<Offerer> findAll(Pageable pageable);
    @Query("""
                 SELECT 'offerer' as type, COALESCE(COUNT(DISTINCT o.identity_number),0) as "person" , COALESCE(SUM(o.guest_capacity),0) as "capacity" FROM offerers o;
            """)
    StatisticDto findOffererStatistics();

    @Modifying
    @Query("UPDATE offerers SET status = :status WHERE id = :id ")
    boolean updateStatus(UUID id, String status);
}
