package com.example.demo;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements
        BankTransactionFilter {

    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.date().getMonth() == Month.FEBRUARY
                && bankTransaction.amount() >= 1000;
    }
}
