package com.redis_cache_with_mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note")
public class Notes implements Serializable {

    @Id
    private String id;

    @Column(nullable = false, length = 100)
    private String title;
    private String content;
    private Date addedNote;
    private boolean live=false;

}
