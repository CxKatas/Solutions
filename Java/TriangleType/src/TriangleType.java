/*
 * Copyright (c) 1996-2018, Construx Software, Inc., All Rights Reserved.
 *
 * This code is the exclusive property of Construx Software, Inc. It may ONLY
 * be used by learners during Construx's workshops or by individuals who are
 * being coached by Construx on a project.
 *
 * This code may NOT be copied or used for any other purpose without the prior
 * written consent of Construx Software, Inc.
 */


/**
 * Implements the core functionality for the self-assessment test in
 * "The Art of Software Testing, Second Edition" by Glenford Myers (2004).
 *
 * @author Melvin Perez-Cedano
 */
public enum TriangleType {
    INVALID, SCALENE, EQUILATERAL, ISOSCELES;

    /**
     * This function takes three integer values as arguments representing the
     * lengths of the sides of a triangle, and states whether the triangle is:
     * - INVALID (the side lengths do not form a triangle),
     * - SCALENE (all sides have different lengths),
     * - ISOSCELES (two sides have the same length), or
     * - EQUILATERAL (all sides have the same length).
     */
    public static TriangleType classify(final int a, final int b, final int c) {
        if (a + b <= c || b + c <= a || a + c <= b)
            return INVALID;
        if (a == b && b == c) return EQUILATERAL;
        else if (a == b || b == c || c == a) return ISOSCELES;
        else return SCALENE;
    }
}

