package com.chyld.messaging;

import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.services.RunService;
import org.hibernate.Hibernate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
public class PosService {
    private RunService service;

    @Autowired
    public void setService(RunService service) {
        this.service = service;
    }

    @RabbitListener(queues = "fit.queue.pos")
    @Transactional
    public void receive(Message msg, HashMap<String, Object> data) {
        String key = msg.getMessageProperties().getReceivedRoutingKey();
        // String id = (String) data.get("id");
        int id = (int) data.get("id");
        Position position = (Position) data.get("position");
        //Run r = service.findActiveRunByDeviceId(Integer.parseInt(id));
        Run r = null;
        r = service.findActiveRunByDeviceId(id);
        if (null != r) {
            r.getPositions().add(position);
            position.setRun(r);
            service.saveRun(r);
        }
    }
}
