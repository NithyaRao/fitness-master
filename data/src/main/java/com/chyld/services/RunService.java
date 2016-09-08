package com.chyld.services;

import com.chyld.entities.Run;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunService {
    private IRunRepository repository;

    @Autowired
    public void setRepository(IRunRepository repository) {
        this.repository = repository;
    }

    public Run findById(int id) { return this.repository.findById(id); }

    public Run saveRun(Run run) { return repository.save(run); }

    public Run findActiveRunByDeviceId(int id) { return repository.findActiveRunByDeviceId(id); }
}
