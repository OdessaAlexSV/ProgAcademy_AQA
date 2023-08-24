package org.prog.hwtask.exceptions.payment;

public class InvalidPaymentAmountException extends RuntimeException {
  public InvalidPaymentAmountException(String message) {
    super(message);
  }
}
