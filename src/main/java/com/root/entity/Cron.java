package com.root.entity;

public class Cron {
    private String cronId;
 
    private String cron;
 
    public String getCronId() {
        return cronId;
    }
 
    public void setCronId(String cronId) {
        this.cronId = cronId == null ? null : cronId.trim();
    }
 
    public String getCron() {
        return cron;
    }
 
    public void setCron(String cron) {
        this.cron = cron == null ? null : cron.trim();
    }
}
