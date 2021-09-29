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
public enum State {

	TELANGANA("Telangana"),
	ANDHRA_PRADESH("Andhra Pradesh"),
	KARNATAKA("Karnataka"),
	KERALA("Kerala"),
	TAMIL_NADU("Tamil Nadu"),
	ODISHA("Odisha"),
	HARYANA("Haryana"),
	WEST_BENGAL("West Bengal"),
	MAHARASHTRA("MahaRashtra"),
	PUNJAB("Punjab"),
	MADHYA_PRADESH("Madhya Pradesh"),
	UTTAR_PRADESH("Uttar Pradesh"),
	BIHAR("Bihar"),
	RAJASTHAN("Rajasthan"),
	GUJARAT("Gujarat");

	private String state;

	public static State generateState() {
		State[] states = State.values();
		Random random = new Random();
		final Integer index = random.ints(0, (states.length - 1)).limit(1).findFirst().getAsInt();
		return states[index];
	}

}