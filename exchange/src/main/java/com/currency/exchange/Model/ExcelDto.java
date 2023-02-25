package com.currency.exchange.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "ratesdata")
@Entity
public class ExcelDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long request_id;

    private String baseCurrency;
    private String conversionCurrency;
    private Double rate;
    private Timestamp createTs;
}
