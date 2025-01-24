<script setup>
import { computed, defineProps } from 'vue';

const weatherConditionsToOptions = {
    "Sunny":{
        "textPT": "Ensolarado",
        "cardClass": "sunny-card-body",
        "iconClass": "wi wi-day-sunny card-logo text-sunny",
    },
    "Cloudy":{
        "textPT": "Nublado",
        "cardClass": "cloudy-card-body",
        "iconClass": "wi wi-cloudy card-logo text-sunny",
    },
    "Partly cloudy":{
        "textPT": "Parcialmente Nublado",
        "cardClass": "",
        "iconClass": "wi wi-day-cloudy-high card-logo",
    },
    "Overcast":{
        "textPT": "Encoberto",
        "cardClass": "cloudy-card-body",
        "iconClass": "wi wi-day-sunny-overcast card-logo",
    },
    "Clear":{
        "textPT": "Limpo",
        "cardClass": "",
        "iconClass": "wi wi-day-sunny card-logo",
    },
    "Rainy":{
        "textPT": "Chovendo",
        "cardClass": "rainy-card-body",
        "iconClass": "wi wi-rain card-logo text-rainy",
    },
    "Light rain":{
        "textPT": "Chuva Leve",
        "cardClass": "rainy-card-body",
        "iconClass": "wi wi-showers card-logo",
    },
    "Moderate rain":{
        "textPT": "Chuva Moderada",
        "cardClass": "rainy-card-body",
        "iconClass": "wi wi-showers card-logo",
    },
    "Mist":{
        "textPT": "Neblina",
        "cardClass": "rainy-card-body",
        "iconClass": "wi wi-day-fog card-logo",
    },
    "Freezing fog":{
        "textPT": "Neblina Congelante",
        "cardClass": "rainy-card-body",
        "iconClass": "wi wi-fog card-logo",
    },
    "Heavy snow":{
        "textPT": "Neve intensa",
        "cardClass": "",
        "iconClass": "wi wi-snow-wind card-logo",
    },
    "Blizzard":{
        "textPT": "Nevasca",
        "cardClass": "",
        "iconClass": "wi wi-snow-wind card-logo",
    },
    "Default":{
        "textPT": "N/A",
        "cardClass": "",
        "iconClass": "",
    }
};

const { location, current } = defineProps({
    location:Object,
    current:Object,
});

const weatherConditionOptions = computed(
    ()=> weatherConditionsToOptions[current.condition.text||"Default"]
);

console.log(current);
console.log(location);

</script>


<template>
    <div class="col w-25 mb-sm-0">
        <div class="card">
        <div class="card-body rounded-top" :class="weatherConditionOptions.cardClass">
            <div class="d-flex justify-content-between">
            <i :class="weatherConditionOptions.iconClass"></i>
            <div class="col text-end">
                <div class="row">
                <span class="card-body-text ">{{ weatherConditionOptions.textPT }}</span>
                </div>
                <div class="row">
                <span class="temp-c text-temperature">{{ current.temp_c }}ºC</span>
                </div>
                <div class="row">
                <span class="card-body-text">{{ `${location.name}, ${location.region}` }}</span>
                </div>
            </div>
            </div>
        </div>
        <div class="card-footer">
            <div class="row">
            <span class="card-body-text">Ultima atualização: {{ current.last_updated }}</span>
            </div>
            <div class="d-flex flex-column card-body-text mt-2">
            <div class="d-flex justify-content-between">
                <span>Humidade:</span>
                <span>{{ current.humidity }}%</span>
            </div>
            <div class="d-flex justify-content-between">
                <span>Vento (Mph):</span>
                <span>{{ current.wind_mph }}</span>
            </div>
            <div class="d-flex justify-content-between">
                <span>UV:</span>
                <span>{{ current.uv }}</span>
            </div>
            </div>
        </div>
        </div>
    </div>
</template>

<style scoped>
    .card-body-text{
        font-weight: 200;
        font-size: 0.75rem;
    }
    .text-sunny{
        color: var(--sunny-svg);
    }
    .sunny-card-body{
        background: var(--sunny);
    }
    .card-logo{
        font-size: 3rem;
    }
    .text-temperature{

        font-size: 2rem;
        font-weight: 200;
    }

    .cloudy-card-body{
        background-color: var(--cloudy);
    }
    .text-cloudy{
        color: var(--cloudy-svg)
    }

    .rainy-card-body{
        background-color: var(--rainy);
    }
    .text-rainy{
        color: var(--rainy-svg);
    }


</style>
