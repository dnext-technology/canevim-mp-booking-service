package com.zorgundostu.booking.repository;

import com.zorgundostu.booking.model.offer.Offerer;
import com.zorgundostu.booking.model.request.Requester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffererRepository extends CrudRepository<Offerer, Long> {
    Page<Offerer> findAll(Pageable pageable);
}
