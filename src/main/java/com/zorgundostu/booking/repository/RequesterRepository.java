package com.zorgundostu.booking.repository;

import com.zorgundostu.booking.model.request.Requester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequesterRepository extends CrudRepository<Requester, Long> {
    Page<Requester> findAll(Pageable pageable);
}
