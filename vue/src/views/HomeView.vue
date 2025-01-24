<script setup>
import {ref, onMounted} from 'vue';
import WeatherCard from '../components/WeatherCard.vue';
import { ReturnLocationInfo, logEnvApi } from '../service/WeatherAPIService.js';

const WeatherForecast = ref(null);

const citiesNames = ['Santos', 'Sao', 'Rio', 'Cubatao', 'Paris', 'Hovden'];

// Função para buscar os dados da API
const fetchWeatherData = async (cityName) => {
    const result = await ReturnLocationInfo(cityName);

    if(result.error){
        console.error(result.error);
        return;
    }

    return result;
};

const fetchAllWeathers = async (citiesNames) => (await Promise.all(
    citiesNames.map(fetchWeatherData)
)).filter(result => result != null);

const weatherForecasts = ref([]);
console.log(weatherForecasts.value);

onMounted(async () => {
    fetchAllWeathers(citiesNames).then(forecasts => {
        weatherForecasts.value = forecasts;
    });
});

// console.log(weatherForecasts);

</script>

<template>
    <div class="row row-cols-1 row-cols-md-3 g-4 mt-2 ms-2 me-2">
        <WeatherCard
            v-for="weatherForecast in weatherForecasts"
            v-bind=weatherForecast
        >
        </WeatherCard>


    </div>
    
   
   
    
</template>