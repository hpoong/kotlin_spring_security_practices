package com.hopoong.kotlin_security.api.account

import org.hibernate.annotations.CreationTimestamp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
@Table(name = "acc_user")
data class AccountModel(

    @Id @GeneratedValue // primary key
    var id: Long? = null,

    var email: String,

    var password: String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    var roles: MutableSet<AccountRole>,

    @CreationTimestamp
    var createDt: LocalDateTime = LocalDateTime.now()
) {

    fun getAuthorities(): User {
        return User(
            this.email, this.password,
            this.roles.stream().map { SimpleGrantedAuthority("ROLE_$it") }.collect(Collectors.toSet())
        )
    }
}