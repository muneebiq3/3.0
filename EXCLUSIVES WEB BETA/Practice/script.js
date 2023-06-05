const phone = {
    brand: "Apple",
    number: "555-555-5555",
    call: function(phoneNumber) {
        this.brand="PineApple"
        console.log("Calling " + this.brand);
    }
};
phone.call("Zia")
console.log(phone.brand);