


// document.getElementById("salary")
// let salary = document.getElementById("salary").innerText;
// let salary = $("#salary12").val();
// let apiUrl = `http://localhost:8000/tax/calculate?salary=${salary}`;
// // console.log(salary)
// taxBtnElm.on('click',()=>{
//     console.log(salary)
//     // calculateTax();
// });
//
// function calculateTax() {
//
//     const jqxhr = $.ajax(apiUrl);
//     jqxhr.done((salary1) => {
//         console.log(salary1);
//         taxShowElm.text(salary1);
//     });
//     jqxhr.fail(() => {
//     });
// }
$(document).ready(function() {

let taxShowElm = $("#result");
    let taxButton = $("#tax");
    let etfButton = $("#etf");
    let tableRow = $("#eft-row");



    // Attach an event listener to the button
    taxButton.on("click", function() {
        // Get the value of the input field
        let value = $("#salary12").val();
        let apiUrl = `http://localhost:8000/tax/calculate?salary=${value}`;
        calculateTax(apiUrl);

    });
    etfButton.on("click", function() {
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
function calculateETF(apiUrl) {

    const jqxhr = $.ajax(apiUrl);
    jqxhr.done((etfList) => {
       tableRow.empty();
        etfList.forEach(value=>{

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




