package org.prog.hwtask;

import org.prog.hwtask.exceptions.payment.BankProcessingFailureException;
import org.prog.hwtask.exceptions.payment.InvalidPaymentAmountException;
import org.prog.hwtask.exceptions.payment.InvalidPaymentClientIdException;
import org.prog.hwtask.exceptions.payment.InvalidPaymentCurrencyException;

import java.util.List;
import java.util.Random;

public class BankPayment {

  public static List<String> SUPPORTED_OF_CURRENCY = List.of("USD", "EUR", "GBP", "UAH");

  public String processPayment(Payment payment) throws InvalidPaymentCurrencyException,
      InvalidPaymentAmountException, InvalidPaymentClientIdException {
    if (!SUPPORTED_OF_CURRENCY.contains(payment.getCurrency())) {
      throw new InvalidPaymentCurrencyException(String.format("The currency %s is not supported",
          payment.getCurrency()));
    }

    if (payment.getPaymentAmount() <= 0) {
      throw new InvalidPaymentAmountException("Negative or zero payment amount.");
    }

    if (payment.getClientId().length() < 5) {
      throw new InvalidPaymentClientIdException("Wrong clientID number, must be more 5 chars long.");
    }
    return requestBankProcessing(payment.getPaymentAmount());
  }

  private String requestBankProcessing(Long paymentAmount) throws BankProcessingFailureException {
    int statusCode;
    if (paymentAmount > 0) {
      Random random = new Random();
      statusCode = random.nextInt(10);
      if (statusCode > 5) {
        throw new BankProcessingFailureException(statusCode);
      }
      return "trx_4knfsf4gs412355";
    } else {
      statusCode = -1;
      throw new BankProcessingFailureException(statusCode);
    }
  }
}
