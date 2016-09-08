package com.chyld.messaging;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

@Service
public class RService {
    private RunService service;
    private DeviceService deviceService;

    @Autowired
    public void setService(RunService service) {
        this.service = service;
    }

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RabbitListener(queues = "fit.queue.run")
    @Transactional
    public void receive(Message msg, int id) {
        String key = msg.getMessageProperties().getReceivedRoutingKey();
        Run run = service.findActiveRunByDeviceId(id);

        if (key.equals("fit.topic.run.start")) {
            if ( null == run) {
                Device d = deviceService.findById(id);
                Run r = new Run();
                r.setDevice(d);
                r.setStartTime(new Date());
                d.getRuns().add(r);
                deviceService.saveDevice(d);
            }
        } else {
           if (null != run) {
            run.setStopTime(new Date());
            service.saveRun(run);
            }
        }

    }
}
