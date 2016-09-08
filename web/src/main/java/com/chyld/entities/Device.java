package com.chyld.entities;

import com.chyld.enums.ExerciseEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "devices")
// @Data
public class Device {
    private int id;
    private int version;
    private String serial_id;
    private String product;
    private String category;
    private User user;
    private Date created;
    private Date modified;
    private List<Run> runs;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Version
    public int getVersion() {return version;}
    public void setVersion(int version) {this.version = version;}

    @Column(nullable = false)
    public String getSerial_id() {
        return serial_id;
    }
   public void setSerial_id(String serial_id) {
        this.serial_id = serial_id;
    }

    @Column(nullable = false)
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }

    @Column(nullable = false)
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    @CreationTimestamp
    public Date getCreated() {return created;}
    public void setCreated(Date created) {this.created = created;}

    @UpdateTimestamp
    public Date getModified() {return modified;}
    public void setModified(Date modified) {this.modified = modified;}


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    public List<Run> getRuns() {
        return runs;
    }
    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }
}
