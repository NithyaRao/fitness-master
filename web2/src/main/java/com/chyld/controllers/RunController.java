package com.chyld.controllers;

import com.chyld.entities.Run;
import com.chyld.entities.Device;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/runs")
public class RunController {

    private DeviceService deviceService;
    private RunService runService;

    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }
    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    public void setTopicExchange(TopicExchange topicExchange) {
        this.topicExchange = topicExchange;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Run> getRuns(@PathVariable int id) {
        Device u = deviceService.findById(id);
        return u.getRuns();
    }

    @RequestMapping(value = "/{id}/start", method = RequestMethod.POST)
    public Run startRun(@PathVariable int id) {
//        Device d = deviceService.findById(id);
//
//        for(Run r : d.getRuns()) {
//            if(r.getStopTime() == null) {
//                return null;
//            }
//        }
//        Run r = new Run();
//        r.setDevice(d);
//        r.setStartTime(new Date());
//        d.getRuns().add(r);
//        deviceService.saveDevice(d);
//        return r;

        String topicName = topicExchange.getName();
        rabbitTemplate.convertAndSend(topicName, "fit.topic.run.start", id);
        return null;
    }

    @RequestMapping(value = "/{id}/stop", method = RequestMethod.POST)
    public Run stopRun(@PathVariable int id) {
//        Run run = runService.findActiveRunByDeviceId(id);
//
//        if (null != run) {
//            run.setStopTime(new Date());
//            // deviceService.saveDevice(d);
//            runService.saveRun(run);
//        }
//        return run;
        String topicName = topicExchange.getName();
        rabbitTemplate.convertAndSend(topicName, "fit.topic.run.stop", id);
        return null;
    }
}
