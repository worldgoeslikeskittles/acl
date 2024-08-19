package com.example.acl.service;

import com.example.acl.domain.StorageItem
import com.example.acl.domain.StorageItemMapper
import com.example.acl.domain.StorageItemRepository
import com.example.acl.rest.controller.CreateStorageItemDto
import com.example.acl.rest.dto.StorageItemDto
import org.springframework.stereotype.Service

@Service
class StorageItemService(
    private val productService: ProductService,
    private val storageService: StorageService,
    private val storageItemRepository: StorageItemRepository, private val storageItemMapper: StorageItemMapper
) {

    fun createStorageItem(storageItemDto: CreateStorageItemDto):StorageItemDto = StorageItem().let {
            it.product = productService.findById(storageItemDto.productId)
            it.storage = storageService.getOne(storageItemDto.storageId)
            storageItemRepository.save(it)
        }.let { storageItemMapper.toDto(it) }

    fun getStorageItemsByStorageId(storageId: Long): List<StorageItem> =
        storageItemRepository.findAllByStorageId(storageId)
}