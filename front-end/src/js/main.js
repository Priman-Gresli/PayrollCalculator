$(document).ready(function () {

    let taxShowElm = $("#result");
    let taxButton = $("#tax");
    let etfButton = $("#etf");
    let tableRow = $("#eft-row");
    let setMinBtn = $("#min-salary-btn");
    let minSalaryElm = $("#min-salary");


    // Attach an event listener to the button
    taxButton.on("click", function () {
        // Get the value of the input field
        let value = $("#salary12").val();
        let apiUrl = `http://localhost:8000/tax/calculate?salary=${value}`;
        calculateTax(apiUrl);

    });
    setMinBtn.on("click", function () {
        // Get the value of the input field
        console.log("wada")
        let value = $("#minSalaryElm").val();
        let apiUrl = `http://localhost:8000/application`;
        setMinSalary(apiUrl);

    });
    etfButton.on("click", function () {
        // Get the value of the input field
        let value = $("#emplyee").val();
        console.log(value)
        let apiUrl = `http://localhost:8000/employee/payroll/${value}`;
        calculateETF(apiUrl);

    });

//
    function calculateTax(apiUrl) {

        const jqxhr = $.ajax(apiUrl);
        jqxhr.done((salary1) => {
            taxShowElm.text(`Rs:${salary1}`);
        });
        jqxhr.fail(() => {
        });
    }

    function setMinSalary(apiUrl) {
        const requestBody = {
            propertyname: "minSalary",
            propertyvalue: minSalaryElm.val()
        };
        console.log(requestBody);
        const jqxhr = $.ajax(apiUrl, {
            method: 'POST',
            data: JSON.stringify(requestBody),
            contentType: "application/json",       // by default jQuery uses application/x-www-form-urlencoded
            processData: false          // by default jQuery tries to convert the data into String
        });
    }

        function calculateETF(apiUrl) {

            const jqxhr = $.ajax(apiUrl);
            jqxhr.done((etfList) => {
                tableRow.empty();
                etfList.forEach(value => {

                    console.log(value)
                    tableRow.append(`<td>${value.takeHomeSalary}</td>`);
                    tableRow.append(`<td>${value.etf}</td>`);
                    tableRow.append(`<td>${value.epf}</td>`);

                })
            });
            jqxhr.fail(() => {
            });
        }
});




