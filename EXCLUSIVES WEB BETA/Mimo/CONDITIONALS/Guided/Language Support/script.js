let message=""
let language="English"
language="Japanese"
language="Spanish"
language="German"
language="Urdu"
if(language === "English"){
    message="Thank you"
}
else if(language === "Spanish"){
    message="Gracias"
}
else if(language === "German"){
    message="Danke"
}
else if(language === "Urdu"){
    message="Shukriya"
}
else{
    message="We don't support "+language
}
console.log(message)