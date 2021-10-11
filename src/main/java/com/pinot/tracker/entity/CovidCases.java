package com.pinot.tracker.entity;

import lombok.Data;

import java.util.UUID;

/**
 * Created on 27/September/2021 By Author Eresh, Gorantla
 **/
@Data
public class CovidCases {
	private String id = UUID.randomUUID().toString();
	private String patientName;
	private String contactNumber;
	private String emailId;
	private String status;
	private Integer directContacts;
	private Integer inDirectContacts;
	private String city;
	private String state;
	private String patientStability;
	private String additionalInfo;
	private String notes;
	private Long reportedTime;
	private Long createdTime;

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return String return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return String return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId the emailId to set
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Integer return the directContacts
     */
    public Integer getDirectContacts() {
        return directContacts;
    }

    /**
     * @param directContacts the directContacts to set
     */
    public void setDirectContacts(Integer directContacts) {
        this.directContacts = directContacts;
    }

    /**
     * @return Integer return the inDirectContacts
     */
    public Integer getInDirectContacts() {
        return inDirectContacts;
    }

    /**
     * @param inDirectContacts the inDirectContacts to set
     */
    public void setInDirectContacts(Integer inDirectContacts) {
        this.inDirectContacts = inDirectContacts;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String return the patientStability
     */
    public String getPatientStability() {
        return patientStability;
    }

    /**
     * @param patientStability the patientStability to set
     */
    public void setPatientStability(String patientStability) {
        this.patientStability = patientStability;
    }

    /**
     * @return String return the additionalInfo
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * @param additionalInfo the additionalInfo to set
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    /**
     * @return String return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return Long return the reportedTime
     */
    public Long getReportedTime() {
        return reportedTime;
    }

    /**
     * @param reportedTime the reportedTime to set
     */
    public void setReportedTime(Long reportedTime) {
        this.reportedTime = reportedTime;
    }

    /**
     * @return Long return the createdTime
     */
    public Long getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime the createdTime to set
     */
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

}