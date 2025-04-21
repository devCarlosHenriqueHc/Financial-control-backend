package com.financialcontrol.controllers;

import com.financialcontrol.dto.TransactionDTO;
import com.financialcontrol.entities.TransactionEntity;
import com.financialcontrol.mappers.TransactionMapper;
import com.financialcontrol.model.TransactionModel;
import com.financialcontrol.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/transactions") // Criando endereço da API
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    // Endpoint para adicionar uma transação
    @PostMapping
    public ResponseEntity<TransactionDTO> addTransaction(@RequestBody TransactionModel transactionModel) {
        TransactionEntity transactionEntity = transactionService.addTransaction(transactionModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionMapper.toDTO(transactionEntity));
    }

    // Endpoint para buscar todas as transações
    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionEntity> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactionMapper.toDTOList(transactions));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable UUID id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

}
