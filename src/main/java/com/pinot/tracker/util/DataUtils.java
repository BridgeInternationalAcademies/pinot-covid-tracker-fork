package com.pinot.tracker.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created on 27/September/2021 By Author Eresh, Gorantla
 **/
public final class DataUtils {

	private static final Supplier<String> mobileSupplier =
			() -> String.format("%01d%01d%01d%01d%01d%01d%01d0%01d%01d%01d", ThreadLocalRandom.current().nextInt(6, 9),
			                    ThreadLocalRandom.current().nextInt(9), ThreadLocalRandom.current().nextInt(9),
			                    ThreadLocalRandom.current().nextInt(9), ThreadLocalRandom.current().nextInt(9),
			                    ThreadLocalRandom.current().nextInt(9), ThreadLocalRandom.current().nextInt(9),
			                    ThreadLocalRandom.current().nextInt(9), ThreadLocalRandom.current().nextInt(9),
			                    ThreadLocalRandom.current().nextInt(9));

	public static String generateMobileNumber() {
		return Stream.generate(mobileSupplier).limit(1).findFirst().orElse(null);
	}

	public static String generateEmailId() {
		return RandomStringUtils.randomAlphabetic(ThreadLocalRandom.current()
		                                                           .nextInt(8, 15)) + "@gmail.com";
	}

	public static Integer generateDirectContacts() {
		return ThreadLocalRandom.current()
		                        .nextInt(1, 10);
	}

	public static Integer generateInDirectContacts() {
		return ThreadLocalRandom.current()
		                        .nextInt(5, 20);
	}

	public static String generateName() {
		return RandomStringUtils.randomAlphabetic(ThreadLocalRandom.current()
		                                                           .nextInt(5, 10)) + RandomStringUtils.randomAlphabetic(ThreadLocalRandom.current()
		                                                                                                                                  .nextInt(5, 10));
	}

	public static Long generateCreatedOn() {
		LocalDateTime localDate = LocalDateTime.now();
		/*int year = ThreadLocalRandom.current().nextInt(2018, 2020);
		int month = ThreadLocalRandom.current().nextInt(1, 12);*/
		int day = ThreadLocalRandom.current().nextInt(1, 28);
		int hour =  ThreadLocalRandom.current().nextInt(0, 23);
		int minutes =  ThreadLocalRandom.current().nextInt(1, 59);
		int seconds =  ThreadLocalRandom.current().nextInt(1, 59);
		int nanoSeconds =  ThreadLocalRandom.current().nextInt(100, 900);
		return LocalDateTime.of(2021, 9, day, hour, minutes, seconds, nanoSeconds).toEpochSecond(ZoneOffset.UTC);
	}



}