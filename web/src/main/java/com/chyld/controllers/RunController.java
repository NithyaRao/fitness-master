package com.chyld.controllers;

import com.chyld.entities.Run;
import com.chyld.entities.Device;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import com.chyld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/runs")
public class RunController {

    private DeviceService deviceService;
    private RunService runService;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Run> getRuns(@PathVariable int id) {
        Device u = deviceService.findById(id);
        return u.getRuns();
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    public Run startRun(@PathVariable int id) {
        Device d = deviceService.findById(id);

        for(Run r : d.getRuns()) {
            if(r.getStopTime() == null) {
                return null;
            }
        }
        Run r = new Run();
        r.setDevice(d);
        r.setStartTime(new Date());
        d.getRuns().add(r);
        deviceService.saveDevice(d);
        return r;
    }

    @RequestMapping(value = "/{id}/stop", method = RequestMethod.POST)
    public Run stopRun(@PathVariable int id) {
        Run run = runService.findActiveRunByDeviceId(id);
//        Device d = deviceService.findById(id);
//        Run run = null;
//        for(Run r : d.getRuns()) {
//            if(r.getStopTime() == null) {
//                r.setStopTime(new Date());
//                run = r;
//                System.out.println("i found it because i'm awesome!!");
//            }
//        }

        if (null != run) {
            run.setStopTime(new Date());
            // deviceService.saveDevice(d);
            runService.saveRun(run);
        }
        return run;
    }
}
