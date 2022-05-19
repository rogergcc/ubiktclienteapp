package com.rohitjakhar.mvvmtemplate.data.repository

import com.rohitjakhar.mvvmtemplate.data.local.model.DataModel
import com.rohitjakhar.mvvmtemplate.data.remote.dto.GetDataDto
import com.rohitjakhar.mvvmtemplate.data.remote.dto.toDataModel
import com.rohitjakhar.mvvmtemplate.data.remote.webservice.SevidorWebApi
import com.rohitjakhar.mvvmtemplate.domain.repository.ClientesRepository
import com.rohitjakhar.mvvmtemplate.domain.repository.DataRepo
import com.rohitjakhar.mvvmtemplate.util.ErrorType
import com.rohitjakhar.mvvmtemplate.util.Resource
import java.net.SocketTimeoutException
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val sevidorWebApi: SevidorWebApi
) : ClientesRepository {

//    override suspend fun getData(): Resource<DataModel> {
//        try {
//            val task = sevidorWebApi.getData()
//            if (task.isSuccessful) {
//                task.body()?.let {
//                    return Resource.Success(data = it.toDataModel())
//                } ?: return Resource.Error(errorType = ErrorType.EMPTY_DATA)
//            } else {
//                return Resource.Error()
//            }
//        } catch (e: SocketTimeoutException) {
//            return Resource.Error(errorType = ErrorType.TIME_OUT)
//        } catch (e: Exception) {
//            return Resource.Error(message = e.localizedMessage)
//        }
//    }

//    override suspend fun getCoins(): Resource<DataModel> {
//        return sevidorWebApi.getData()
//    }


    override suspend fun getData(): List<GetDataDto> {
        return sevidorWebApi.getData()
    }

}
