package com.example.acl.service;

import com.example.acl.domain.Storage
import com.example.acl.repository.StorageRepository
import com.example.acl.rest.controller.CreateStorageDto
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.io.IOException
import java.util.*

@Service
class StorageService(private val storageRepository: StorageRepository, private val objectMapper: ObjectMapper) {
    fun getList(): List<Storage> {
        return storageRepository.findAll()
    }

    fun getOne(id: Long): Storage {
        val storageOptional: Optional<Storage> = storageRepository.findById(id)
        return storageOptional.orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `$id` not found")
        }
    }

    fun getMany(ids: List<Long>): List<Storage> {
        return storageRepository.findAllById(ids)
    }

    fun create(storage: CreateStorageDto): Storage {
        return storageRepository.save(Storage().apply { storageNumber = storage.storageNumber })
    }

    fun delete(id: Long): Storage? {
        val storage: Storage? = storageRepository.findById(id).orElse(null)
        if (storage != null) {
            storageRepository.delete(storage)
        }
        return storage
    }

    fun deleteMany(ids: List<Long>) {
        storageRepository.deleteAllById(ids)
    }
}