//This function show one field at a time of vehicle section
function vehicleDetails(event) {
    var parentElement = event.target.parentElement;
    var nextSibling = parentElement.nextElementSibling;

    var errorMessage = [];
    switch (event.target.id) {
        case "vc-name":
            document.getElementById("vc-input-label").innerHTML = "What is your vehicle type ";
            showNextField(parentElement, nextSibling);
            break;

        case "cycle":
            document.getElementById("vc-input-label").innerHTML = "What is your vehicle number ";
            parentElement = parentElement.parentElement;
            nextSibling = parentElement.nextElementSibling;
            showNextField(parentElement, nextSibling);
            break;

        case "motercycle":
            document.getElementById("vc-input-label").innerHTML = "What is your vehicle number ";
            parentElement = parentElement.parentElement;
            nextSibling = parentElement.nextElementSibling;
            showNextField(parentElement, nextSibling);
            break;

        case "fourwheeler":
            document.getElementById("vc-input-label").innerHTML = "What is your vehicle number ";
            parentElement = parentElement.parentElement;
            nextSibling = parentElement.nextElementSibling;
            showNextField(parentElement, nextSibling);
            break;

        case "vc-number":
            if (validateVehicleNumber(event.target.value)) {
                document.getElementById("vc-input-label").innerHTML = "What is your employee id? ";
                showNextField(parentElement, nextSibling);
            }
            else {
                errorMessage.push("Enter complete number of vechicle ex: RJ02-CA-1234");
                event.target.style = "border: 2px solid red";
            }
            break;

        case "emp-id":
            if (validateEmpId(event.target.value)) {
                document.getElementById("vc-input-label").innerHTML = "What are the identification marks of your vehicle? To submit text click outside the box";
                showNextField(parentElement, nextSibling);
            }
            else {
                event.target.style = "border: 2px solid red";
            }
            break;

        case "id-textarea":
            parentElement.classList.add("display-none");
            document.getElementById("vc-input-label").classList.add("display-none");
            document.getElementById("add-vc").classList.remove("display-none");
            break;

        case "add-vc":
            break;

        default:
            console.log("Invalid id");
    }
    if (errorMessage.length > 0) {
        var errorDiv = document.getElementById("vc-error-element");
        errorDiv.classList.remove("display-none");
        errorDiv.innerHTML = errorMessage.join(', ');
    }
    if (errorMessage.length == 0)
        document.getElementById("vc-error-element").classList.add("display-none");
}

//This function is to collapse vehicle form
function getPass() {
    var vcType = getRadioButtonValue(document.getElementsByName("vehicle-type"));
    console.log("vcType: "+vcType);
    document.getElementById("vehicle-form").classList.add("display-none");
    displayPlan();
}

//This function will validate employee id
function validateEmpId(employeeId) {
    var regex = /^([a-zA-Z0-9\/]{1,})$/;
    return regex.test(employeeId);
}

//This function is to validate vehicle number
function validateVehicleNumber(number) {
    var regex = /^([a-zA-Z0-9-]{12,12})$/;
    return regex.test(number);
}