package edu.loyola.cs485.gfbb.model.entity;

public class Reservation extends AbstractEntity {
    private Integer id = null;
    private java.sql.Timestamp dateTime = null;
    private String status;
    private Integer numGuests = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(java.sql.Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(Integer numGuests) {
        this.numGuests = numGuests;
    }

    @Override
    public String toString(){
        return getId().toString()+ ": " +getDateTime().toString()+": "+getStatus().toString()+": "+getNumGuests().toString();
    }


}
