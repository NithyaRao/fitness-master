package com.chyld.repositories;

import com.chyld.entities.Device;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDeviceRepository extends PagingAndSortingRepository<Device, Integer> {
    public Device findById(int id);
}
