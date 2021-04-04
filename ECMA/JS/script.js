
let coll = document.getElementsByClassName("collapsible");
let i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click",  function(){
        this.classList.toggle("active");
        let content = this.nextElementSibling;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}

//This method hides current field and display next field
let showNextField = (parentElement, nextSibling) => {
    parentElement.classList.add("display-none");
    nextSibling.classList.remove("display-none");
}

//This method gets the value for the radio button
let getRadioButtonValue = (radio) => {
    let index = 0;
    for (index = 0; index < radio.length; index++) {
        if (radio[index].checked)
            return radio[index].value;
    }
    return null;
}