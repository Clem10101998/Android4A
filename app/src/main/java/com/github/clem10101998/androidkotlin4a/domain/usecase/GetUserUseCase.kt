package com.github.clem10101998.androidkotlin4a.domain.usecase

import com.github.clem10101998.androidkotlin4a.data.repository.UserRepository
import com.github.clem10101998.androidkotlin4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String, password: String) : User? {
    return userRepository.getUser(email, password)
    }
}