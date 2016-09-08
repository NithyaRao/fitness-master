package com.chyld.repositories;

import com.chyld.entities.Run;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRunRepository extends PagingAndSortingRepository<Run, Integer> {
    public Run findById(int id);

    @Query("select distinct r from Device d join d.runs r where d.id = :id and r.stopTime is null")
    public Run findActiveRunByDeviceId(@Param("id") int id);
}
