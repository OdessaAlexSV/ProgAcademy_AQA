package org.prog.hwtask.exceptions.payment;

public class InvalidPaymentCurrencyException extends RuntimeException{
  public InvalidPaymentCurrencyException(String message) {
    super(message);
  }
}
