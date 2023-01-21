package com.surajmanshal.jettrivia.repository

import android.util.Log
import com.surajmanshal.jettrivia.data.DataOrException
import com.surajmanshal.jettrivia.model.QuestionItem
import com.surajmanshal.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isEmpty()) dataOrException.loading = false
        } catch (e: Exception) {
            dataOrException.e = e
            Log.d("EXC", "Error ${e.localizedMessage} ")
        }
        return dataOrException
    }
}