function displayPlan() {
    document.getElementById("pricing").classList.remove("display-none");
    var cyclePricePlan = {
        "daily": 5,
        "monthly": 100,
        "yearly": 500
    };
    var motercyclePricePlan = {
        "daily": 10,
        "monthly": 200,
        "yearly": 1000
    };
    var fourwheelerPricePlan = {
        "daily": 20,
        "monthly": 500,
        "yearly": 3500
    };
    var currencySymbol = "USD";
    var vcType = getRadioButtonValue(document.getElementsByName("vehicle-type"));
    var selectedVehiclePlan;
    switch (vcType) {
        case "cycle":
            document.getElementById("vechicle-title").innerHTML = "Cycle Price Plans";
            selectedVehiclePlan = cyclePricePlan;
            break;
        case "motercycle":
            document.getElementById("vechicle-title").innerHTML = "Motercycle Price Plans";
            selectedVehiclePlan = motercyclePricePlan;
            break;
        case "fourwheeler":
            document.getElementById("vechicle-title").innerHTML = "Fourwheeler Price Plans";
            selectedVehiclePlan = fourwheelerPricePlan;
            break;
    }


    var selectedCurrency = getCurrency();
    switch (selectedCurrency) {
        case "yen":
            selectedVehiclePlan = usdToYen(selectedVehiclePlan);
            currencySymbol = "YEN";
            break;
    }

    document.getElementById("daily-price").innerHTML = selectedVehiclePlan["daily"] + currencySymbol;
    document.getElementById("monthly-price").innerHTML = selectedVehiclePlan["monthly"] + currencySymbol;
    document.getElementById("yearly-price").innerHTML = selectedVehiclePlan["yearly"] + currencySymbol;
}
function getCurrency() {
    var currency = document.getElementsByName("currency")[0].children;
    var selectedCurrency, index;
    for (index = 0; index < currency.length; index++) {
        if (currency[index].selected)
            selectedCurrency = (currency[index].value);
    }
    return selectedCurrency;
}
function usdToYen(selectedVehiclePlan) {
    var yenBaseValue = 110;
    console.log(selectedVehiclePlan);
    selectedVehiclePlan["daily"] *= yenBaseValue;
    selectedVehiclePlan["monthly"] *= yenBaseValue;
    selectedVehiclePlan["yearly"] *= yenBaseValue;
    return selectedVehiclePlan;
}
