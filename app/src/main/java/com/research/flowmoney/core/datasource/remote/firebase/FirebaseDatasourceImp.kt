package com.research.flowmoney.core.datasource.remote.firebase

import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.research.flowmoney.core.model.Data
import com.research.flowmoney.core.model.DataState
import kotlinx.coroutines.tasks.await

class FirebaseDatasourceImp : FirebaseDatasource {

    private val personCollectionRef = Firebase.firestore.collection("persons")

    override suspend fun addData(data: Data): DataState<Data> {
        return try {
            val result = personCollectionRef.add(data).await()
            val addedDocumentSnapshot = result.get().await()
            val addedData = addedDocumentSnapshot.toObject(Data::class.java)
            if (addedData != null) {
                DataState.Success(addedData)
            } else {
                DataState.Error("Data is null")
            }
        } catch (e: Exception) {
            DataState.Error(e.localizedMessage ?: "${e.message}")
        }

    }


}