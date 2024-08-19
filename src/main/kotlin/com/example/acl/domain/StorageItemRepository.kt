package com.example.acl.domain;

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface StorageItemRepository : JpaRepository<StorageItem, Long> {

    @EntityGraph(attributePaths = ["storage"])
    fun findAllByStorageId(storageId:Long): List<StorageItem>
}