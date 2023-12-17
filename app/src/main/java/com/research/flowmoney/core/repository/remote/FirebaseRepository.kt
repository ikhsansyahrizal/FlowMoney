package com.research.flowmoney.core.repository.remote

import com.research.flowmoney.core.model.Data
import com.research.flowmoney.core.model.DataState

interface FirebaseRepository {

    suspend fun addData(title: String, amount: Int): DataState<Data>

}