package com.github.clem10101998.androidkotlin4a.injection

import com.github.clem10101998.androidkotlin4a.MainViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}
