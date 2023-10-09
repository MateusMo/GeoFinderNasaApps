package com.example.geofinder.data
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationViewModel: ViewModel() {
    // Dados do formulário
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var zoom: Int = 0

    // Função para fazer a solicitação POST
    fun makeHttpPostRequest() {
        val locationData = LocationData(latitude, longitude, zoom)

        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Faça a solicitação HTTP POST usando o repositório
                val response = LocationRepository().sendLocationData(locationData)

                // Handle the response, e.g., update UI or navigate to the image activity
                val responseBody = response.body?.string()
                val mapSurvey = Gson().fromJson(responseBody, MapSurveyDTO::class.java)

                // Aqui você pode lidar com os dados da resposta, como a imagem ou outras informações

            } catch (e: Exception) {
                // Trate erros de rede ou exceções
                e.printStackTrace()
            }
        }
    }
}