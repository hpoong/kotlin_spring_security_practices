package com.hopoong.kotlin_security.api.account

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepositoy: JpaRepository<AccountModel, Long> {
    fun findByEmail(username: String): AccountModel
}