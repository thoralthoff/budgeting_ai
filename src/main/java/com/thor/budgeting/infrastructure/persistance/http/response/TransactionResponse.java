package com.thor.budgeting.infrastructure.persistance.http.response;

import com.thor.budgeting.application.ouput.TransactionOutput;
import com.thor.budgeting.domain.Transaction;

import java.math.BigDecimal;

public record TransactionResponse(String id, String category, String description, double amount) {
    public static TransactionResponse from(TransactionOutput output) {
        return new TransactionResponse(output.id(), output.category(), output.description(), output.value());
    }
}
