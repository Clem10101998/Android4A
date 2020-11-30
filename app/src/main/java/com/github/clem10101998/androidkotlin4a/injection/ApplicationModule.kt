package com.github.clem10101998.androidkotlin4a.injection

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Room
import com.github.clem10101998.androidkotlin4a.data.local.AppDatabase
import com.github.clem10101998.androidkotlin4a.data.local.DatabaseDao
import com.github.clem10101998.androidkotlin4a.data.repository.UserRepository
import com.github.clem10101998.androidkotlin4a.domain.usecase.CreateUserUseCase
import com.github.clem10101998.androidkotlin4a.domain.usecase.GetUserUseCase
import com.github.clem10101998.androidkotlin4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import java.security.AccessControlContext

//Application Module permet de créer les classes
val presentationModule = module {
    factory { MainViewModel(get(), get()) }
}
val domainModule = module {
factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDataBase(androidContext()) }

}

fun createDataBase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}
