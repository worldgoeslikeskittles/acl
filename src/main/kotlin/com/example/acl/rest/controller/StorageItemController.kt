package com.example.acl.rest.controller

import com.example.acl.domain.StorageItem
import com.example.acl.rest.dto.StorageItemDto
import com.example.acl.service.StorageItemService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rest/storage/items")
class StorageItemController(private val storageItemService: StorageItemService) {

    @PostMapping
    fun createStorageItem(createStorageItemDto: CreateStorageItemDto): StorageItemDto
       = storageItemService.createStorageItem(createStorageItemDto)

    @GetMapping
    fun getStorageItemsByStorageId(@RequestParam storageId: Long): List<StorageItemDto>
        = storageItemService.getStorageItemsByStorageId(storageId)
            .map { StorageItemDto(it.id, it.product?.name, it.product?.description) }
}

