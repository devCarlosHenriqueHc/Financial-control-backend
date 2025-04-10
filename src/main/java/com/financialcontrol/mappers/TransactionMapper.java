package com.financialcontrol.mappers;

import com.financialcontrol.dto.TransactionDTO;
import com.financialcontrol.entities.TransactionEntity;
import com.financialcontrol.model.TransactionModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public TransactionEntity toEntity(TransactionModel transactionModel){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setType(transactionModel.getType());
        transactionEntity.setAmount(transactionModel.getAmount());
        transactionEntity.setDescription(transactionModel.getDescription());
        transactionEntity.setCreatedAt(transactionModel.getCreatedAt());
        return transactionEntity;
    }

    public TransactionDTO toDTO(TransactionEntity transactionEntity){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transactionEntity.getId());
        transactionDTO.setType(transactionEntity.getType());
        transactionDTO.setAmount(transactionEntity.getAmount());
        transactionDTO.setDescription(transactionEntity.getDescription());
        transactionDTO.setCreatedAt(transactionEntity.getCreatedAt());
        return transactionDTO;
    }

    // Novo método para converter uma lista de entidades para uma lista de DTOs
    public List<TransactionDTO> toDTOList(List<TransactionEntity> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
