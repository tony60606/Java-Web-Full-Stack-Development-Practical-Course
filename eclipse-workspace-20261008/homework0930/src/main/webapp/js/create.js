/**
 * 
 */


document.addEventListener("DOMContentLoaded", () => {

    const dateInput = document.getElementById("date");

    if (dateInput) {
        dateInput.min = new Date().toLocaleDateString("sv-SE");
    }

});