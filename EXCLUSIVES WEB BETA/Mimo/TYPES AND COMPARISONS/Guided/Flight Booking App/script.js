const nameOnPass="Muneeb"
const nameOnId="Muneeb"
const nameMatch=nameOnId==nameOnPass
const length=20
const doesLengthPass=length<30
const height=45
const doesHeightPass=height<55
const isHandBaggageEligible=doesHeightPass==true&&doesLengthPass==true
const flightDes="Karachi"
const returnFrom="Karachi"
const isRoundTrip=flightDes==returnFrom
const bookings=12
const totalCapacity=15
const isFlightAvailable=bookings<totalCapacity
console.log("Passenger Name: "+nameOnPass)
console.log("ID confirmerd? "+nameMatch)
console.log("Is Hand Baggage Eligible? "+isHandBaggageEligible)
console.log("Round Trip Check? "+isRoundTrip)
console.log("Are seats available? "+isFlightAvailable)
document.querySelector("#name").innerHTML = nameOnPass;
document.querySelector("#id").innerHTML = nameMatch;
document.querySelector("#bag").innerHTML = isHandBaggageEligible;
document.querySelector("#des").innerHTML = isRoundTrip;
document.querySelector("#seat").innerHTML = isFlightAvailable;