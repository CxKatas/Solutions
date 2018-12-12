import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
// Copyright (c) 2018, Construx Software, Inc., All Rights Reserved.
//
// This code is the exclusive property of Construx Software, Inc. It may ONLY 
// be used by learners during Construx's workshops or by individuals who are 
// being coached by Construx on a project.
//
// This code may NOT be copied or used for any other purpose without the prior
// written consent of Construx Software, Inc.
// ***************************************************************************/

/**
 * @author melvinperez
 *
 */
class LifeTest {
	private Life life;

	// Any live cell with fewer than two live neighbors dies, as if caused by
	// under-population.
	@Test
	void aLiveCellWithFewerThanTwoLiveNeighborsDies() throws Exception {
		life.tick();
		assertFalse(life.isAlive(2, 4));
	}

	// Any live cell with more than three live neighbors dies, as if by
	// overcrowding.
	@Test
	void aLiveCellWithMoreThanThreeLiveNeighborsDies() throws Exception {
		life.setLiveCellAt(3, 4);
		life.tick();
		assertFalse(life.isAlive(3, 4));
	}

	// Any live cell with two or three live neighbors lives on to the next
	// generation.
	@Test
	void aLiveCellWithTwoLiveNeighborsLives() throws Exception {
		life.tick();
		assertTrue(life.isAlive(4, 5));
	}

	@Test
	void aLiveCellWithThreeLiveNeighborsLives() throws Exception {
		life.tick();
		assertTrue(life.isAlive(4, 4));
	}

	// Any dead cell with exactly three live neighbors becomes a live cell.
	@Test
	void aDeadCellWithThreeLiveNeighborsBecomesALiveCell() throws Exception {
		life.tick();
		assertTrue(life.isAlive(3, 3));
	}

	@Test
	void weCanSeeTheWorld() throws Exception {
		String expectedDashboard = "|.|.|.|.|.|.|.|.|" + "\n" + "|.|.|.|*|.|.|.|.|" + "\n" + "|.|.|.|.|*|.|.|.|" + "\n"
				+ "|.|.|*|*|*|.|.|.|" + "\n" + "|.|.|.|.|.|.|.|.|" + "\n" + "|.|.|.|.|.|.|.|.|" + "\n";

		assertEquals(expectedDashboard, life.dashboard());
		System.out.println(expectedDashboard);
		life.tick();
		System.out.println(life.dashboard());
	}

	@BeforeEach
	public void glider() {
		life = new Life(6, 8);
		///// 1 2 3 4 5 6 7 8
		// 1 |.|.|.|.|.|.|.|.|
		// 2 |.|.|.|*|.|.|.|.|
		// 3 |.|.|.|.|*|.|.|.|
		// 4 |.|.|*|*|*|.|.|.|
		// 5 |.|.|.|.|.|.|.|.|
		// 6 |.|.|.|.|.|.|.|.|
		life.setLiveCellAt(2, 4);
		life.setLiveCellAt(3, 5);
		life.setLiveCellAt(4, 3);
		life.setLiveCellAt(4, 4);
		life.setLiveCellAt(4, 5);
	}
}
