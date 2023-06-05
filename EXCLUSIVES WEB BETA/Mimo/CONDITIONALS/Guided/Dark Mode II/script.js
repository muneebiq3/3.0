function selectMode(mode) {
    var color="ghostWhite"
    var image="https://mimo.app/i/light-icon.png";
    var label="Light Mode"
    if(mode == "dark"){
        color="darkSlateBlue"
        image="https://mimo.app/i/dark-icon.png"
        label="Dark Mode"
    } else if(mode == "light"){
        color="ghostWhite"
        image="https://mimo.app/i/light-icon.png"
        label="Light Mode"
    } else{
        color="dimGray"
        image="https://mimo.app/i/ninja-icon.png"
        label="Ninja Mode"
    }
    document.getElementById("icon").src=image
    document.getElementById("theme").style.backgroundColor=color
    document.getElementById("label").innerHTML=label
}