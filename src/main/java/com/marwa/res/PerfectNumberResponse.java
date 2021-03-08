package com.marwa.res;

import java.util.List;

public class PerfectNumberResponse {
  private Boolean isPerfect;
  private List<Integer> perfectNumbers;

  public PerfectNumberResponse(Boolean isPerfect, List<Integer> perfectNumbers) {
    this.isPerfect = isPerfect;
    this.perfectNumbers = perfectNumbers;
  }

  public Boolean getPerfect() {
    return isPerfect;
  }


  public List<Integer> getPerfectNumbers() {
    return perfectNumbers;
  }

}
