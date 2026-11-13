package com.thor.budgeting.infrastructure.persistance.repository;

import com.thor.budgeting.domain.Category;
import com.thor.budgeting.infrastructure.persistance.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    List<TransactionEntity> findAllByCategory(Category category);
}
