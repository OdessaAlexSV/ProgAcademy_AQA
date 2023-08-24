package org.prog.hwtask;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Payment {

  public String currency;
  public Long paymentAmount;
  public String clientId;

  @Override
  public String toString() {
    return "Payment{" +
        "currency='" + currency + '\'' +
        ", paymentAmount=" + paymentAmount +
        ", clientId=" + clientId +
        '}';
  }
}
