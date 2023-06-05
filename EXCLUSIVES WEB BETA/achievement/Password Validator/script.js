const inputEl=document.querySelector("input");
const eyeEl=document.querySelector(".input i");
const checkListEl=document.querySelectorAll(".allChecks li");
const checks=[
    { regex: /.{10,}/, index: 0},
    { regex: /[A-Z]/, index: 1},
    { regex: /[a-z]/, index: 2},
    { regex: /[^A-Za-z0-9]/, index: 3},
    {regex: /[0-9]/, index: 4}
]
inputEl.addEventListener("keyup", (event) => {checks.forEach(e => {
        const valid=e.regex.test(event.target.value);
        const checkItem=checkListEl[e.index];
        if(valid){
        checkItem.style="text-decoration: line-through";
        } else{
        checkItem.style="text-decoration: none";
        }
    });
});
eyeEl.addEventListener("click", () => {
    eyeEl.className=`fa-solid fa-eye${
        inputEl.type === "password" ? "" : "-slash"}`;
    inputEl.type=inputEl.type === "password" ? "text" : "password";});