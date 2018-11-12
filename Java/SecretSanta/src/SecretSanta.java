/*******************************************************************************
 * Copyright (c) 2017, Construx Software, Inc., All Rights Reserved.
 * 
 * This code is the exclusive property of Construx Software, Inc. and it may ONLY 
 * be used by learners or individuals who are being trained or coached by 
 * Construx Software, Inc.
 * 
 * This code may NOT be copied or used for any other purpose without the 
 * prior written consent of Construx Software, Inc..
 ******************************************************************************/


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretSanta {
	private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 4;
	List<String> participants = new ArrayList<>();

	public void addParticipant(String participant) {
		if (!participants.contains(participant))
			participants.add(participant);
	}

	public int getNumberOfParticipants() {
		return participants.size();
	}

	public Collection<String> getParticipants() {
		return participants;
	}

	public Map<String, String> getSantas() {
		if (participants.size() < MINIMUM_NUMBER_OF_PARTICIPANTS)
			throw new IllegalStateException();

		Map<String, String> pairs = new HashMap<>();

		Collections.shuffle(participants);
		for (String giver : participants) {
			String receiver = participants.get((participants.indexOf(giver) + 1) % participants.size());
			pairs.put(giver, receiver);
		}

		return pairs;
	}
}
