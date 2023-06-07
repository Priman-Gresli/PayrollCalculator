const taxBtnElm = $("#tax");
const taxShowElm = $("#result");

let salary = $("#salary").val();
let apiUrl = `http://localhost:8000/tax/calculate?salary=${salary}`;
console.log(salary)
taxBtnElm.on('click',()=>{
    console.log(salary)
    // calculateTax();
});

function calculateTax() {

    const jqxhr = $.ajax(apiUrl);
    jqxhr.done((salary1) => {
        console.log(salary1);
        taxShowElm.text(salary1);
    });
    jqxhr.fail(() => {
    });
}

function loadAll() {
    // const ajax = $.ajax(REST_API_URL + "/images");
    // ajax.done((imageList) => {
    //     imageList.forEach(imageUrl => {
    //         console.log(imageUrl);
    //         const divElm = $(`<div class="image"><span class="material-symbols-outlined">download</span></div>`);
    //         divElm.css('background-image', `url(${imageUrl})`);
    //         imageDivElm.append(divElm);
    //     })
    // })
}


