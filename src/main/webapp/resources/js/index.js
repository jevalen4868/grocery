$(function() {
    $("#searchBtn").on('click', function(e) {
        var search = $('#grocerySearch').val();
        window.location.href = "/grocery/search/" + search;
    });
})