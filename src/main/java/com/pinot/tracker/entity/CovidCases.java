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
}