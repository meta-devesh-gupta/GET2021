//This function will show one field at a time of employee section
let empDetails = (event) => {
    let parentElement = event.target.parentElement;
    let nextSibling = parentElement.nextElementSibling;

    let errorMessage = [];
    switch (event.target.id) {
        case "name":
            if (validateName(event.target.value)) {
                let name = event.target.value;
                document.getElementById("input-label").innerHTML = `Hi ${name} ! Can I know your gender?`;
                showNextField(parentElement, nextSibling);
            }
            else {
                errorMessage.push("Invalid name...Length min 2 and should not be numeric");
                event.target.style = "border: 2px solid red";
            }
            break;
        case "male":
            document.getElementById("input-label").innerHTML = "Can I know your email? ";
            parentElement = parentElement.parentElement;
            nextSibling = parentElement.nextElementSibling;
            showNextField(parentElement, nextSibling);
            break;
        case "female":
            document.getElementById("input-label").innerHTML = "Can I know your email? ";
            parentElement = parentElement.parentElement;
            nextSibling = parentElement.nextElementSibling;
            showNextField(parentElement, nextSibling);
            break;
        case "email":
            if (validateEmail(event.target.value)) {
                document.getElementById("input-label").innerHTML = "Please enter your password ";
                showNextField(parentElement, nextSibling);
            }
            else {
                errorMessage.push("Invalid email...should contain @ .");
                event.target.style = "border: 2px solid red";
            }
            break;
        case "password":
            if (validatePassword(event.target.value)) {
                document.getElementById("input-label").innerHTML = "Please confirm your password ";
                showNextField(parentElement, nextSibling);
            }
            else {
                errorMessage.push("Incorrect Password...should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8");
                event.target.style = "border: 2px solid red";
            }
            break;
        case "confirm-pass":
            if (validateConfirmPassword(event.target.value)) {
                document.getElementById("input-label").innerHTML = "Please enter your contact number ";
                showNextField(parentElement, nextSibling);
            }
            else {
                errorMessage.push("Password mismatch");
                event.target.style = "border: 2px solid red";
            }
            break;
        case "number":
            if (validateContactNumber(event.target.value)) {
                document.getElementById("enumber-row").classList.add("display-none");
                document.getElementById("input-label-div").classList.add("display-none");
                document.getElementById("submitbutton").classList.remove("display-none");
            }
            else {
                errorMessage.push("Invalid contact number...Numbers only, length > 8");
                event.target.style = "border: 2px solid red";
            }
            break;
        default:
            console.log("Invalid id");
    }
    if (errorMessage.length > 0) {
        let errorDiv = document.getElementById("error-element");
        errorDiv.classList.remove("display-none");
        errorDiv.innerHTML = errorMessage.join(', ');
    }
    if (errorMessage.length == 0)
        document.getElementById("error-element").classList.add("display-none");
}

//This function will collapse the employee form
let submitEmpForm = () => {
    document.getElementById("employee-form").classList.add("display-none");
    getRegisterationId();
}

//This function will generate the registeration id of the employee
let getRegisterationId = () => {
    // document.getElementById("employee-form").submit();
    registrationId = "Registeration Id: " + Math.floor(Math.random() * 10000) + 1;
    document.getElementById("addEmpButton").innerText = registrationId;
    return registrationId;
}

//This function will validate the name of the employee
let validateName = (name) => {
    name = name.trim();
    let regex = /^([a-zA-Z ]{2,})$/;
    return regex.test(name);
}

//This function will validate the email of the employee
let validateEmail = (email) => {
    email = email.trim();
    let regex = /^([a-zA-Z0-9\.-]+)@([a-zA-Z0-9-]+)\.([a-z]{2,})$/;
    return regex.test(email);
}

//This function will validate the password of the employee
let validatePassword = (password) => {
    let regex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    return regex.test(password);
}

//This function is to validate the confirm password
let validateConfirmPassword = (confirmPassword) => {
    let password = document.getElementById("password").value;
    return (password == confirmPassword);
}

//This function is to validate contact number of the employee
let validateContactNumber = (number) => {
    let regex = /^([0-9]{8,})$/;
    return regex.test(number);
}

//This function change the border color according to password strength
let passwordValidation = (event) => {
    let passwordField = event.target.value;
    if (!validatePassword(passwordField)) {
        event.target.style = "border: 2px solid red";
    }
    else if (passwordField.length > 8 && passwordField.length < 12)
        event.target.style = "border: 2px solid orange";
    else if (passwordField.length >= 12)
        event.target.style = "border: 2px solid green";
}