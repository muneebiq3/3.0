const maxPoints=120
const passingPoints=70
const samPoints=81
const alexPoints=75
const jessiePoints=99
const didAlexPass=!false
const samPointsDisplay="Sam earned "+samPoints+" points out of "+maxPoints
const alexPointsDisplay="Alex earned "+alexPoints+" points out of "+maxPoints
const jessiePointsDisplay="Jessie earned "+jessiePoints+" points out of "+maxPoints
const samPercentage=(samPoints/maxPoints)*100
const alexPercentage=(alexPoints/maxPoints)*100
const jessiePercentage=(jessiePoints/maxPoints)*100
const samPercentDisplay="Sam scored "+samPercentage+"%."
const alexPercentDisplay="Alex scored "+alexPercentage+"%."
const jessiePercentDisplay="Jessie scored "+jessiePercentage+"%."
const samMissedPoints=maxPoints-samPoints
const alexMissedPoints=maxPoints-alexPoints
const jessieMissedPoints=maxPoints-jessiePoints
const samMissedPointsDisplay="Sam missed "+samMissedPoints+" point(s)."
const alexMissedPointsDisplay="Alex missed "+alexMissedPoints+" point(s)."
const jessieMissedPointsDisplay="Jessie missed "+jessieMissedPoints+" point(s)."
const classAveragePoints=(samPoints+alexPoints+jessiePoints)/3
const classAveragePercent=(classAveragePoints/maxPoints)*100
const classAvgDisplay="The class average was "+classAveragePoints+" or "+classAveragePercent+"%."
const alexPointsUpdated="Alex failed initially but did extra credit. Their new score is "+alexPoints+" out of "+maxPoints
const listItemArray = document.querySelectorAll("li");
listItemArray[0].innerHTML = "Raw Points:";
listItemArray[4].innerHTML = "Percentages:";
listItemArray[8].innerHTML = "Missed Points:";
listItemArray[12].innerHTML = "Final Notes:";
console.log(samPointsDisplay)
console.log(alexPointsDisplay)
console.log(jessiePointsDisplay)
console.log(samPercentDisplay)
console.log(alexPercentDisplay)
console.log(jessiePercentDisplay)
console.log(samMissedPointsDisplay)
console.log(alexMissedPointsDisplay)
console.log(jessieMissedPointsDisplay)
console.log(classAvgDisplay)
console.log(alexPointsUpdated)
listItemArray[1].innerHTML = samPointsDisplay;
listItemArray[2].innerHTML = alexPointsDisplay;
listItemArray[3].innerHTML = jessiePointsDisplay;
listItemArray[5].innerHTML = samPercentDisplay;
listItemArray[6].innerHTML = alexPercentDisplay;
listItemArray[7].innerHTML = jessiePercentDisplay;
listItemArray[9].innerHTML = samMissedPointsDisplay;
listItemArray[10].innerHTML = alexMissedPointsDisplay;
listItemArray[11].innerHTML = jessieMissedPointsDisplay;
listItemArray[13].innerHTML = classAvgDisplay;
listItemArray[14].innerHTML = alexPointsUpdated;