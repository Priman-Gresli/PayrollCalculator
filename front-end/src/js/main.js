$(document).ready(function () {

    let taxShowElm = $("#result");
    let taxButton = $("#tax");
    let etfButton = $("#etf");
    let tableRow = $("#eft-row");
    let setMinBtn = $("#min-salary-btn");
    let minSalaryElm = $("#min-salary");
    let costBtn = $("#cost");
    let costElm = $("#cost-result");
    let showEmpBtn = $("#emp");
    let empTableBody = $("#emp-tbody");

    showEmpBtn.on("click", function () {
        let apiUrl = "http://localhost:8000/employee/salary-distribution";
        showEmployee(apiUrl);

    });
    costBtn.on("click", function () {
        let value = $("#employee-id").val();
        let apiUrl = `http://localhost:8000/employee/totalcost/${value}`;
        calculateCost(apiUrl);

    });
    taxButton.on("click", function () {
        let value = $("#salary12").val();
        let apiUrl = `http://localhost:8000/tax/calculate?salary=${value}`;
        calculateTax(apiUrl);

    });
    setMinBtn.on("click", function () {
        let value = $("#minSalaryElm").val();
        let apiUrl = `http://localhost:8000/application`;
        setMinSalary(apiUrl);

    });
    etfButton.on("click", function () {
        let value = $("#emplyee").val();
        let apiUrl = `http://localhost:8000/employee/payroll/${value}`;
        calculateETF(apiUrl);

    });


    function calculateTax(apiUrl) {

        const jqxhr = $.ajax(apiUrl);
        jqxhr.done((salary1) => {
            taxShowElm.text(`Rs:${salary1}`);
        });
        jqxhr.fail(() => {
        });
    }

    function calculateCost(apiUrl) {

        const jqxhr = $.ajax(apiUrl);
        jqxhr.done((salary1) => {

            costElm.text(`Rs:${salary1}`);
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
            contentType: "application/json",
            processData: false
        });
    }

    function calculateETF(apiUrl) {
        const jqxhr = $.ajax(apiUrl);
        jqxhr.done((etfList) => {
            tableRow.empty();
            etfList.forEach(value => {
                tableRow.append(`<td>${value.takeHomeSalary}</td>`);
                tableRow.append(`<td>${value.etf}</td>`);
                tableRow.append(`<td>${value.epf}</td>`);

            })
        });
        jqxhr.fail(() => {
        });
    }

    function showEmployee(apiUrl) {
        const jqxhr = $.ajax(apiUrl);
        jqxhr.done((empList) => {
            empTableBody.empty();
            empList.forEach(value => {
                empTableBody.append(`
                    <tr>
                        <td>${value.employeeId}</td>  
                        <td>${value.employeeName}</td>  
                        <td>${value.takeHomeSalary}</td>  
                        <td>${value.epf}</td>  
                        <td>${value.etf}</td>
                        <td>${value.tax}</td>
                    </tr>
                    `);
            })

        });
        jqxhr.fail(() => {
        });
    }
});




