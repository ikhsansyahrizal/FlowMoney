package com.research.flowmoney.core.repository.remote

import com.research.flowmoney.core.datasource.remote.firebase.FirebaseDatasource
import com.research.flowmoney.core.model.Data
import com.research.flowmoney.core.model.DataState

class FirebaseRepositoryImp(private val firebaseDatasource: FirebaseDatasource) :
    FirebaseRepository {

    override suspend fun addData(title: String, amount: Int): DataState<Data> {
        val dataToAdd = Data(title = title, amount = amount)
        return firebaseDatasource.addData(dataToAdd)
    }


}