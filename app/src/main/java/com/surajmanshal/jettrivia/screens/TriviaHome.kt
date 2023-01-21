package com.surajmanshal.jettrivia.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.surajmanshal.jettrivia.component.Questions


@Composable
fun TriviaHome(viewmodel: QuestionsViewmodel = hiltViewModel()){
    Questions(viewmodel)
}