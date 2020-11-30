package com.github.clem10101998.androidkotlin4a.domain.usecase

import com.github.clem10101998.androidkotlin4a.data.repository.UserRepository
import com.github.clem10101998.androidkotlin4a.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
    userRepository.createUser(user)
    }
}