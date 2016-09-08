package com.chyld.services;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.repositories.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PositionService {
    private IPositionRepository repository;
    DeviceService deviceService;
    RunService runService;

    @Autowired
    public void setRepository(IPositionRepository repository) {
        this.repository = repository;
    }
    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }
    @Autowired
    public void setDeviceService(DeviceService deviceService) { this.deviceService = deviceService; }

    public Position findById(int id){
        return this.repository.findById(id);
    }

    public Position createPosition(Position position, int deviceId) {
        Run run = runService.findActiveRunByDeviceId(deviceId);
        if (null != run) {
            position.setCurrentTime(new Date());
            position.setRun(run);
            run.getPositions().add(position);
            runService.saveRun(run);
        }
//        Device d = deviceService.findById(deviceId);
//        for(Run r : d.getRuns()) {
//            if(r.getStopTime() == null) {
//                position.setCurrentTime(new Date());
//                position.setRun(r);
//                r.getPositions().add(position);
//                runService.saveRun(r);
//            }
//        }

        return position;
    }
}
