package com.marwa.res;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PerfectNumberJunit {
  private static PerfectNumberService perfectNumberService;

  @BeforeAll
  static void setup() {
    perfectNumberService = new PerfectNumberService();
  }

  @Test
  void passPerfectNumber_shouldReturn_perfectNumber() {
    Assertions.assertTrue(perfectNumberService.getPerfectNumberResponse(6).getPerfect(), "Expected perfect number");
  }

  @Test
  void passNotPerfectNumber_shouldNotReturn_perfectNumber() {
    Assertions.assertFalse(perfectNumberService.getPerfectNumberResponse(1).getPerfect(), "Expected non perfect number");
  }

  @Test
  void passRange_shouldReturn_listOfPerfectNumbers() {
    Assertions.assertEquals(perfectNumberService.getPerfectNumberResponseInRange(1, 10000).getPerfectNumbers().size(), 4);

  }
}