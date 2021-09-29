package com.pinot.tracker.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

/**
 * Created on 27/September/2021 By Author Eresh, Gorantla
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PatientStability {

	UNDETERMINED("Undetermined"),
	GOOD("Good"),
	FAIR("Fair"),
	SERIOUS("Serious"),
	CRITICAL("Critical");

	private String stability;

	public static PatientStability generatePatientStability() {
		PatientStability[] patientStabilities = PatientStability.values();
		Random random = new Random();
		final Integer index = random.ints(0, (patientStabilities.length - 1)).limit(1).findFirst().getAsInt();
		return patientStabilities[index];
	}
}