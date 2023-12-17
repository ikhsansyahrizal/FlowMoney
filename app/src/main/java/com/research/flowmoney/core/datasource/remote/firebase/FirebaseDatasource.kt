package com.research.flowmoney.core.datasource.remote.firebase

import com.research.flowmoney.core.model.Data
import com.research.flowmoney.core.model.DataState

interface FirebaseDatasource {

    suspend fun addData(data: Data): DataState<Data>

}