package com.thor.budgeting.infrastructure.persistance.http.request;

import com.thor.budgeting.application.input.PersistTransactionInput;
import com.thor.budgeting.domain.Category;

public record TransactionRequest(String description, Category category, long amount) {
    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
