package com.example.acl.repository;

import com.example.acl.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface UserRepository: JpaRepository<User, Long> , JpaSpecificationExecutor<User> {
}