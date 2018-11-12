/*******************************************************************************
 * Copyright (c) 2017, Construx Software, Inc., All Rights Reserved.
 * 
 * This code is the exclusive property of Construx Software, Inc. and it may ONLY 
 * be used by individuals who are being trained and coached by Construx Software, Inc..
 * 
 * This code may NOT be copied or used for any other purpose without the prior
 * written consent of Construx Software, Inc.
 ******************************************************************************/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

public class SecretSantaTest {

	private static final int MINIMUM_NUMBER_OF_PARTICIPANTS = 4;
	private SecretSanta sut;

	@Before
	public void setup() {
		sut = new SecretSanta();
	}

	@Test
	public void atTheBeginningThereAreNoParticipants() {
		assertEquals(0, sut.getNumberOfParticipants());
	}

	@Test
	public void aParticipantIsAdded() {
		addThisManyParticipants(1);
		assertEquals(1, sut.getNumberOfParticipants());
	}

	private void addThisManyParticipants(int howMany) {
		for (int i = 0; i < howMany; i++) {
			sut.addParticipant("participant"+i);
		}
	}
	
	@Test
	public void requireUniqueParticipants() {
		addThisManyParticipants(1);
		addThisManyParticipants(1);
		assertEquals(1, sut.getNumberOfParticipants());
	}

	@Test (expected = IllegalStateException.class)
	public void requireMinimumParticipants() {
		addThisManyParticipants(MINIMUM_NUMBER_OF_PARTICIPANTS - 1);
		sut.getSantas();
	}
	
	@Test
	public void everyParticipantIsAGiver() {
		addMinimumNumberOfParticipants();
		assertTrue(sut.getSantas().keySet().containsAll(sut.getParticipants()));
	}

	private void addMinimumNumberOfParticipants() {
		addThisManyParticipants(MINIMUM_NUMBER_OF_PARTICIPANTS);
	}
	
	@Test
	public void everyParticipantIsAReceiver() {
		addMinimumNumberOfParticipants();
		assertTrue(sut.getSantas().values().containsAll(sut.getParticipants()));
	}
	
	@Test
	public void ensureNoSelfSantas() {
		addMinimumNumberOfParticipants();
		for (Entry<String, String> pair : sut.getSantas().entrySet())
			assertFalse(pair.getKey() == pair.getValue());
	}
}
