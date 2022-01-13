$(document).ready(function () {

    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });

    $(".dropdown-trigger").dropdown();

    $('#userDeleteModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    })
});