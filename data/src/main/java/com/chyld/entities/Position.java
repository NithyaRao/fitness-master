package com.chyld.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "positions")
// @Data
public class Position implements Serializable {
    private int id;
    private int version;
    private int latitude;
    private int longitude;
    private int altitude;
    private Date currentTime;
    private Run run;
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @Column(nullable = false)
    public int getLatitude() {
        return latitude;
    }
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    @Column(nullable = false)
    public int getLongitude() {
        return longitude;
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    @Column(nullable = false)
    public int getAltitude() {
        return altitude;
    }
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Column(nullable = false, name = "c_time")
    public Date getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    @ManyToOne
    @JoinColumn(name="run_id")
    @JsonIgnore
    public Run getRun() {
        return run;
    }
    public void setRun(Run run) {
        this.run = run;
    }

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}

}
