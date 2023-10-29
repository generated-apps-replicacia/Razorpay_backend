package com.apps.petcare.model;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

public class SubscriptionEntity {
//    private String id;
//    private String entity;
    private String plan_id;
//    private String customer_id;
//    private String status;
//    private long current_start;
//    private long current_end;
//    private Long ended_at;
    private int quantity;
//    private Map<String, String> notes;
//    private long charge_at;
//    private long start_at;
//    private long end_at;
//    private int auth_attempts;
    private int total_count;
//    private int paid_count;
    private int customer_notify;
//    private long created_at;
    private long expire_by;
//    private String short_url;
//    private boolean has_scheduled_changes;
//    private Long change_scheduled_at;
//    private String source;
//    private String payment_method;
//    private String offer_id;
//    private int remaining_count;

    // Getters and setters for the above fields

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getEntity() {
//        return entity;
//    }
//
//    public void setEntity(String entity) {
//        this.entity = entity;
//    }
//
    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }
//
//    public String getCustomer_id() {
//        return customer_id;
//    }
//
//    public void setCustomer_id(String customer_id) {
//        this.customer_id = customer_id;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public long getCurrent_start() {
//        return current_start;
//    }
//
//    public void setCurrent_start(long current_start) {
//        this.current_start = current_start;
//    }
//
//    public long getCurrent_end() {
//        return current_end;
//    }
//
//    public void setCurrent_end(long current_end) {
//        this.current_end = current_end;
//    }
//
//    public Long getEnded_at() {
//        return ended_at;
//    }
//
//    public void setEnded_at(Long ended_at) {
//        this.ended_at = ended_at;
//    }
//
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
//
//    public Map<String, String> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(Map<String, String> notes) {
//        this.notes = notes;
//    }
//
//    public long getCharge_at() {
//        return charge_at;
//    }
//
//    public void setCharge_at(long charge_at) {
//        this.charge_at = charge_at;
//    }
//
//    public long getStart_at() {
//        return start_at;
//    }
//
//    public void setStart_at(long start_at) {
//        this.start_at = start_at;
//    }
//
//    public long getEnd_at() {
//        return end_at;
//    }
//
//    public void setEnd_at(long end_at) {
//        this.end_at = end_at;
//    }
//
//    public int getAuth_attempts() {
//        return auth_attempts;
//    }
//
//    public void setAuth_attempts(int auth_attempts) {
//        this.auth_attempts = auth_attempts;
//    }
//
    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
//
//    public int getPaid_count() {
//        return paid_count;
//    }
//
//    public void setPaid_count(int paid_count) {
//        this.paid_count = paid_count;
//    }
//
    public int isCustomer_notify() {
        return customer_notify;
    }

    public void setCustomer_notify(int customer_notify) {
        this.customer_notify = customer_notify;
    }
//
//    public long getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(long created_at) {
//        this.created_at = created_at;
//    }
//
    public long getExpire_by() {
        return expire_by;
    }

    public void setExpire_by(long expire_by) {
        this.expire_by = expire_by;
    }
//
//    public String getShort_url() {
//        return short_url;
//    }
//
//    public void setShort_url(String short_url) {
//        this.short_url = short_url;
//    }
//
//    public boolean isHas_scheduled_changes() {
//        return has_scheduled_changes;
//    }
//
//    public void setHas_scheduled_changes(boolean has_scheduled_changes) {
//        this.has_scheduled_changes = has_scheduled_changes;
//    }
//
//    public Long getChange_scheduled_at() {
//        return change_scheduled_at;
//    }
//
//    public void setChange_scheduled_at(Long change_scheduled_at) {
//        this.change_scheduled_at = change_scheduled_at;
//    }
//
//    public String getSource() {
//        return source;
//    }
//
//    public void setSource(String source) {
//        this.source = source;
//    }
//
//    public String getPayment_method() {
//        return payment_method;
//    }
//
//    public void setPayment_method(String payment_method) {
//        this.payment_method = payment_method;
//    }
//
//    public String getOffer_id() {
//        return offer_id;
//    }
//
//    public void setOffer_id(String offer_id) {
//        this.offer_id = offer_id;
//    }
//
//    public int getRemaining_count() {
//        return remaining_count;
//    }
//
//    public void setRemaining_count(int remaining_count) {
//        this.remaining_count = remaining_count;
//    }
}
