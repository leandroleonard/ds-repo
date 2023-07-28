$(document).ready(function () {
    showTree();
    searchPreOrder();
    searchPosOrder();
    searchInOrder();
    $('#form-add').submit(function (event) {
        event.preventDefault();

        const number = $("#form-add-number").val();
        const formData = { number: number }
        fetch("api/v1/tree/insert", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(formData)
        })
            .then(response => response.text())
            .then(data => {
                $(".bs-modal-add").modal("hide");
                $("#form-add-number").val("");
                showTree();
                searchPreOrder();
                searchPreOrder();
                searchPosOrder();
                searchInOrder();
                console.log(data);
            }).catch(error => {
                console.error("There was some error during sent the data", error);
            });
    });

    $('#remove').click(function () {

        $.ajax({
            url: "/api/v1/tree/destroy",
            type: 'DELETE',
            success: function () {
                showTree();
                searchPreOrder();
                searchPreOrder();
                searchPosOrder();
                searchInOrder();
            },
            error: function (xhr, status, error) {
                console.log(xhr.responseText)
            }
        });
    });

});

function showTree() {
    $(".content").empty();
    fetch("/api/v1/tree/display")
        .then(response => response.json())
        .then(data => {
            for (var i = 0; i < data.length; i++) createNode(data[i].number, data[i].level, data[i].column);
        })
        .catch(error => {
            console.error('Error:', error);
        })
}
function createNode(value, level, column) {
    var product = $('<span>', { class: 'node', text: value, style: "margin-top: " + (level * 70) + "px; margin-left:" + (200 + column * 70) + "px" });
    $(".content").append(product)
}

function searchPreOrder() {
    $(".content").empty();
    fetch("/api/v1/tree/search-pre-order")
        .then(response => response.json())
        .then(data => {
            $("#preOrder").text(data);
        })
        .catch(error => {
            console.error('Error:', error);
        })
}
function searchPosOrder() {
    $(".content").empty();
    fetch("/api/v1/tree/search-pos-order")
        .then(response => response.json())
        .then(data => {
            $("#posOrder").text(data);
        })
        .catch(error => {
            console.error('Error:', error);
        })
}
function searchInOrder() {
    $(".content").empty();
    fetch("/api/v1/tree/search-in-order")
        .then(response => response.json())
        .then(data => {
            $("#inOrder").text(data);
        })
        .catch(error => {
            console.error('Error:', error);
        })
}