package com.pinot.tracker.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinot.tracker.entity.CovidCases;
import com.pinot.tracker.util.City;
import com.pinot.tracker.util.DataUtils;
import com.pinot.tracker.util.PatientStability;
import com.pinot.tracker.util.State;
import com.pinot.tracker.util.Status;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeType;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created on 27/September/2021 By Author Eresh, Gorantla
 **/
@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConfig {

	private final StreamBridge streamBridge;
	
	public KafkaConfig(StreamBridge streamBridge) {
		this.streamBridge = streamBridge;
	}

	@Value("${spring.cloud.stream.bindings.eventProducer-out-0.content-type}")
	private String streamOutMimeType;

	@Scheduled(fixedDelay = 1000)
	@SneakyThrows
	public void publishCovidTrackerData() {
		List<CovidCases> covidCasesList = generateData();
		covidCasesList.stream().forEach(data -> {
			streamBridge.send("eventProducer-out-0", data, MimeType.valueOf(streamOutMimeType));
		});
	}

	@SneakyThrows
	public List<CovidCases> generateData() {
		Integer limit = ThreadLocalRandom.current().nextInt(0, 5000);
		List<CovidCases> covidCasesList = new ArrayList<>();
		for (int index = 0; index < limit; index++) {
			CovidCases covidCases = new CovidCases();
			covidCases.setId(UUID.randomUUID()
			                     .toString());
			String state = State.generateState()
			                    .getState();
			covidCases.setState(state);
			covidCases.setCity(City.generateCity(state));
			covidCases.setContactNumber(DataUtils.generateMobileNumber());
			covidCases.setPatientName(DataUtils.generateName());
			covidCases.setAdditionalInfo(RandomStringUtils.randomAlphabetic(10));
			covidCases.setNotes(RandomStringUtils.randomAlphabetic(10));
			covidCases.setEmailId(DataUtils.generateEmailId());
			covidCases.setDirectContacts(DataUtils.generateDirectContacts());
			covidCases.setInDirectContacts(DataUtils.generateInDirectContacts());
			covidCases.setReportedTime(DataUtils.generateCreatedOn());
			covidCases.setCreatedTime(DataUtils.generateCreatedOn());
			covidCases.setPatientStability(PatientStability.generatePatientStability()
			                                               .getStability());
			covidCases.setStatus(Status.generateStatus()
			                           .getStatus());
			covidCasesList.add(covidCases);
		}
		//String data = objectMapper.writeValueAsString(covidCases);
		return covidCasesList;
	}
}