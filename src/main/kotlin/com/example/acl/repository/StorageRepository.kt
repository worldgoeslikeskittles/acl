package com.example.acl.repository;

import com.example.acl.domain.Storage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StorageRepository : JpaRepository<Storage, Long>, JpaSpecificationExecutor<Storage> {
}