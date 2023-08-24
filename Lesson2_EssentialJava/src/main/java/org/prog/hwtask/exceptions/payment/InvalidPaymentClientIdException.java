package org.prog.hwtask.exceptions.payment;

public class InvalidPaymentClientIdException extends RuntimeException{
  public InvalidPaymentClientIdException(String message) {
    super(message);
  }
}
