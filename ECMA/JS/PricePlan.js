//This function is to display selected vehicle plan
let displayPlan = () => {
    document.getElementById("pricing").classList.remove("display-none");
    const cyclePricePlan = {
        "daily": 5,
        "monthly": 100,
        "yearly": 500
    };
    const motercyclePricePlan = {
        "daily": 10,
        "monthly": 200,
        "yearly": 1000
    };
    const fourwheelerPricePlan = {
        "daily": 20,
        "monthly": 500,
        "yearly": 3500
    };
    let currencySymbol = "USD";
    const vcType = getRadioButtonValue(document.getElementsByName("vehicle-type"));
    let selectedVehiclePlan;
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

    let selectedCurrency = getCurrency();
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

//This function fetch the selected currency
let getCurrency = () => {
    let currency = document.getElementsByName("currency")[0].children;
    let selectedCurrency, index;
    for (index = 0; index < currency.length; index++) {
        if (currency[index].selected)
            selectedCurrency = (currency[index].value);
    }
    return selectedCurrency;
}

//This function converts the currency of the selected vehicle plan from usd to yen
let usdToYen = (selectedVehiclePlan) => {
    const yenBaseValue = 110;
    selectedVehiclePlan["daily"] *= yenBaseValue;
    selectedVehiclePlan["monthly"] *= yenBaseValue;
    selectedVehiclePlan["yearly"] *= yenBaseValue;
    return selectedVehiclePlan;
}
