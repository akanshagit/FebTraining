package com.exchange.money_exchange.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long request_id;
    String status;
    String request;
    String Reponse;
    Timestamp create_ts;
    Timestamp update_ts;
}
