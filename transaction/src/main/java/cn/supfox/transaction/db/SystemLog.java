package cn.supfox.transaction.db;

import java.time.LocalDate;

public class SystemLog {
    private Integer logId;
    private LocalDate logDate;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
}
