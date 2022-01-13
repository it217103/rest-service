$(document).ready(function () {

});

function generateKey() {
    let randomstring = Math.random().toString(36).slice(-8);
    $("#password").val(randomstring);
    $("#confirmPassword").val(randomstring);
    return console.log("done");
}

function toggleVisiblePassword() {
    let password = document.getElementById("password");
    let confirm = document.getElementById("confirmPassword");
    if (password.type === "password") {
        password.type = "text";
        confirm.type = "text";
    } else {
        password.type = "password";
        confirm.type = "password";
    }
}