
var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var content = this.nextElementSibling;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}

function setMessage(parentElement, nextSibling) {
    parentElement.classList.add("display-none");
    nextSibling.classList.remove("display-none");
}

function getRadioButtonValue(radio) {
    var index = 0;
    for (index = 0; index < radio.length; index++) {
        if (radio[index].checked)
            return radio[index].value;
    }
    return null;
}