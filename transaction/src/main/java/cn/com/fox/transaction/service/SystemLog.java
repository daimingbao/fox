package cn.com.fox.transaction.service;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SystemLog {
    private Integer logId;
    private LocalDate logDate;
}
