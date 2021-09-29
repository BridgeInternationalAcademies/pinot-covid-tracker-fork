package com.pinot.tracker.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 27/September/2021 By Author Eresh, Gorantla
 **/
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum City {

	TELANGANA_CITIES(State.TELANGANA.getState(), Stream.of("Hyderabad", "Warangal", "Khammam", "Nizambad", "ShadNagar").collect(Collectors.toList())),
	ANDHRA_PRADESH_CITIES(State.ANDHRA_PRADESH.getState(), Stream.of("Vijayawada", "Tirupati", "Kurnool", "Anantapur", "Guntur").collect(Collectors.toList())),
	KARNATAKA_CITIES(State.KARNATAKA.getState(), Stream.of("Bangalore", "Mysore", "Mangalore", "Hubli", "Bellary").collect(Collectors.toList())),
	KERALA_CITIES(State.KERALA.getState(), Stream.of("Trivendram", "Kochi", "Kollam", "Kannur", "Thrissur").collect(Collectors.toList())),
	TAMIL_NADU_CITIES(State.TAMIL_NADU.getState(), Stream.of("Chennai", "Madhurai", "Salem", "Vellore", "Erode").collect(Collectors.toList())),
	ODISHA_CITIES(State.ODISHA.getState(), Stream.of("Bhubaneswar", "Puri", "Rourkela", "Cuttak", "Sambalpur").collect(Collectors.toList())),
	HARYANA_CITIES(State.HARYANA.getState(), Stream.of("Faridabad", "Gurugram", "Panipat", "Rohtak").collect(Collectors.toList())),
	WEST_BENGAL_CITIES(State.WEST_BENGAL.getState(), Stream.of("Kolkata", "Haldia", "Shantipur", "Durgapur", "Asansol").collect(Collectors.toList())),
	MAHARASHTRA_CITIES(State.MAHARASHTRA.getState(), Stream.of("Mumbai", "Pune", "Nagpur", "Nasik", "Solapur").collect(Collectors.toList())),
	PUNJAB_CITIES(State.PUNJAB.getState(), Stream.of("Amritsar", "Ludiana", "Jalandhar", "Patiala", "Moga").collect(Collectors.toList())),
	MADHYA_PRADESH_CITIES(State.MADHYA_PRADESH.getState(), Stream.of("Bhopal", "Indore", "Gwalior", "Jabalpur", "Ujjain").collect(Collectors.toList())),
	UTTAR_PRADESH_CITIES(State.UTTAR_PRADESH.getState(), Stream.of("Lucknow", "Varanasi", "Kanpur", "Agra", "Meerut").collect(Collectors.toList())),
	BIHAR(State.BIHAR.getState(), Stream.of("Patna", "Gaya", "Chapra", "Hajipur", "Darbhanga").collect(Collectors.toList())),
	RAJASTHAN_CITIES(State.RAJASTHAN.getState(), Stream.of("Jaipur", "Jodhpur", "Udaipur", "Ajmer", "Jaisalmer").collect(Collectors.toList())),
	GUJARAT_CITIES(State.GUJARAT.getState(), Stream.of("Ahmedabad", "Surat", "Rajkot", "Vadodara", "Gandhinagar").collect(Collectors.toList()));

	private String state;
	private List<String> cities;

	public static String generateCity(String state) {
		City[] cities = City.values();
		City city = Arrays.stream(cities).filter(data -> StringUtils.equalsIgnoreCase(data.getState(), state)).findFirst().orElse(null);
		if (city != null) {
			final Integer index = ThreadLocalRandom.current().nextInt(0, city.cities.size() - 1);
			return city.getCities().get(index);
		}
		return "UNKNOWN";
	}
}