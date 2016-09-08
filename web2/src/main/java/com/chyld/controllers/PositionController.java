package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.entities.Position;
import com.chyld.services.DeviceService;
import com.chyld.services.PositionService;
import com.chyld.services.RunService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private RunService runService;
    private DeviceService deviceService;
    private PositionService positionService;
    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;

    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }
    @Autowired
    public void setDeviceService(DeviceService deviceService) { this.deviceService = deviceService; }
    @Autowired
    public void setPositionService(PositionService positionService) { this.positionService = positionService; }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) { this.rabbitTemplate = rabbitTemplate;}

    @Autowired
    public void setTopicExchange(TopicExchange topicExchange) {
        this.topicExchange = topicExchange;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Position> getLatestRunPositions(@PathVariable int id) {
        Device d = deviceService.findById(id);
        return d.getRuns().get(d.getRuns().size() - 1).getPositions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Position createPosition(@RequestBody Position position, @PathVariable int id) {
//        return positionService.createPosition(position, id);
        String topicName = topicExchange.getName();
        HashMap<String, Object> hm = new HashMap<>();
        hm.put("id", id);
        hm.put("position", position);
        rabbitTemplate.convertAndSend(topicName, "fit.topic.pos", hm);
        return null;
    }
}
