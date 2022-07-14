package ru.barinov.studyapp

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single{
        RVAdapter()
    }

    single{
        Repo(get())
    }

    viewModel<ActivityViewModel>{
        ActivityViewModel(get())
    }
}