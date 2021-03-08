package com.marwa.res;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumberService {

  public PerfectNumberService() {
  }

  /** Response if number is perfect and list perfect numbers in range 1 : 10000
   * @param number
   * @return PerfectNumberResponse
   */
  public PerfectNumberResponse getPerfectNumberResponse(Integer number) {
    List<Integer> perfectNumbers = getPerfectNumbersInRange(1, 10000);
    return new PerfectNumberResponse(perfectNumbers.stream().anyMatch(e -> e.equals(number)), perfectNumbers);

  }


  /** Response list of perfect number in range of start and end
   * @param start
   * @param end
   * @return PerfectNumberResponse
   */
  public PerfectNumberResponse getPerfectNumberResponseInRange(Integer start, Integer end) {
    List<Integer> perfectNumbers = getPerfectNumbersInRange(start, end);

    return new PerfectNumberResponse(null, perfectNumbers);

  }


  /** Find the perfect numbers in a range of number between start and end
   * @param start
   * @param end
   * @return list of perfect numbers
   */
  private List<Integer> getPerfectNumbersInRange(Integer start, Integer end) {
    return IntStream.rangeClosed(start, end)
        .filter(PerfectNumberService::isPerfect)
        .boxed()
        .collect(Collectors.toList());
  }

  /** Check if number is perfect
   * @param number
   * @return is a number is perfect or not
   */
  private static boolean isPerfect(int number) {

    return number == IntStream.rangeClosed(1, number / 2)
        .filter(i -> number % i == 0)
        .sum();
  }
}
