package com.hopoong.kotlin_security.api.account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(
        @Autowired private val accountRepository: AccountRepositoy,
        @Autowired private val passwordEncoder: PasswordEncoder): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return accountRepository.findByEmail(username)?.getAuthorities()
            ?: throw UsernameNotFoundException("$username Can Not Found")
    }


    fun saveAcount(account: AccountModel): AccountModel {
        account.password = this.passwordEncoder.encode(account.password);
        return accountRepository.save(account);
    }

}