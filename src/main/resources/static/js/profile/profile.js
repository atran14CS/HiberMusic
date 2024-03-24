// Displays the search bar
document.getElementById("create-btn").addEventListener("click", function() {
    let createBox = document.getElementById("form-hidden");
    if (createBox.style.display === "none") {
        createBox.style.display = "block";
    } else {
        createBox.style.display = "none";
    }
});