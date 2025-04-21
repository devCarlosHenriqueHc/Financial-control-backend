package com.financialcontrol.services;

import com.financialcontrol.entities.TransactionEntity;
import com.financialcontrol.mappers.TransactionMapper;
import com.financialcontrol.model.TransactionModel;
import com.financialcontrol.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionEntity addTransaction(TransactionModel transactionModel) {
        TransactionEntity transactionEntity = transactionMapper.toEntity(transactionModel);
        transactionEntity.setCreatedAt(LocalDateTime.now());
        return transactionRepository.save(transactionEntity);
    }

    // Buscar todas as transações
    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // 🔥 Novo método para deletar transação
    public void deleteTransaction(UUID id) {
        transactionRepository.deleteById(id);
    }
}
