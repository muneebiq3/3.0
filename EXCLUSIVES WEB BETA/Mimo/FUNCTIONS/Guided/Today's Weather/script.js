function showWeather(high, low){
    console.log("Today's Weather: ")
    if(high>low){
        console.log("High: "+high)
        console.log("Low: "+low)
    }
    else if(low>high){
        console.log("High: "+low)
        console.log("Low: "+high)
    }
}
showWeather(31, 32)