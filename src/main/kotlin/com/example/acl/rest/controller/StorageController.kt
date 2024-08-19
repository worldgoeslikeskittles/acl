package com.example.acl.rest.controller

import com.example.acl.service.StorageService
import com.example.acl.domain.Storage
import com.fasterxml.jackson.databind.JsonNode
import org.springframework.web.bind.annotation.*
import java.io.IOException

@RestController
@RequestMapping("/rest/storages")
class StorageController(private val storageService: StorageService) {
    @GetMapping
    fun getList(): List<Storage> {
        return storageService.getList()
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): Storage {
        return storageService.getOne(id)
    }

    @GetMapping("/by-ids")
    fun getMany(@RequestParam ids: List<Long>): List<Storage> {
        return storageService.getMany(ids)
    }

    @PostMapping
    fun create(@RequestBody storage: CreateStorageDto): Storage {
        return storageService.create(storage)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Storage? {
        return storageService.delete(id)
    }

    @DeleteMapping
    fun deleteMany(@RequestParam ids: List<Long>) {
        storageService.deleteMany(ids)
    }
}
