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
public enum Status {

	ACTIVE("Active"),
	DISCHARGED("Dis Charged"),
	DECEASED("Deceased"),
	NOT_TRACKED("Not Tracked"),
	ABSCOND("Abscond");

	private String status;

	public static Status generateStatus() {
		Status[] statuses = Status.values();
		Random random = new Random();
		final Integer index = random.ints(0, (statuses.length - 1)).limit(1).findFirst().getAsInt();
		return statuses[index];
	}

}