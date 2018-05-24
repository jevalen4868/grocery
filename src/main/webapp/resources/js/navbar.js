/**
 * any controls needed for navbar jsp here.
 */
$(function () {
    $("#logoutLink").on('click', function (e) {
        e.preventDefault();
        $('#logoutForm').submit();
    });
})