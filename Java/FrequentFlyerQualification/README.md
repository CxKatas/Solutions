Frequent Flyer Qualification Status
====================================
A leading airline determines frequent flyers qualification status using a combination of the miles or segments they fly throughout the year, and their annual qualified spending using a loyalty program credit card. As shown in the table below, to earn **Gold** status for example, a frequent flyer needs to fly at least 50000 miles **or** 60 segments, **and** spend at least 5000 dollars on flights using the loyalty program credit card.

| Level    | Miles     | Segments | Dollars  |
| -------- | --------- | -------- | -------- |
| Silver   | 25000     | 30       | 2500     |
| **Gold** | **50000** | **60**   | **5000** |
| Platinum | 75000     | 100      | 7500     |
| Diamond  | 125000    | 140      | 12500    |

The function that determines the qualification status looks like this:

```java
public static Status get(int milesFlown, int segmentsFlown, int dollarsSpent) 
```

Using the domain matrix below, design a set of test cases to cover the input domain for **Gold** *status*.

|                     | Boundary |   TC #1   |   TC #2   |   TC #3   |   TC #4   |   TC #5   |   TC#6    |
| :-----------------: | :------: | :-------: | :-------: | :-------: | :-------: | :-------: | :-------: |
|  **Miles >=50000**  |    ON    |           | ///////// | ///////// | ///////// | ///////// | ///////// |
|                     |   OFF    | ///////// |           | ///////// | ///////// | ///////// | ///////// |
|                     | Typical  | ///////// | ///////// |           |           |           |           |
|  **Segments >=60**  |    ON    | ///////// | ///////// |           | ///////// | ///////// | ///////// |
|                     |   OFF    | ///////// | ///////// | ///////// |           | ///////// | ///////// |
|                     | Typical  |           |           | ///////// | ///////// |           |           |
| **Dollars >=5000**  |    ON    | ///////// | ///////// | ///////// | ///////// |           | ///////// |
|                     |   OFF    | ///////// | ///////// | ///////// | ///////// | ///////// |           |
|                     | Typical  |           |           |           |           | ///////// | ///////// |
| **Expected Status** |          |           |           |           |           |           |           |

