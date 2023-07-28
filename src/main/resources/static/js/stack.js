$(document).ready(function () {
    showStack();
    getTotal();
    $('#form-add').submit(function (event) {
        event.preventDefault();

        const name = $("#form-add-product").val();
        const weight = $("#form-add-weight").val();

        const formData = { name: name, weight: weight };

        fetch("api/v1/shopping-cart/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(formData)
        })
            .then(response => response.text())
            .then(data => {
                $(".bs-modal-add").modal("hide");
                $("#form-add-product").val("");
                $("#form-add-weight").val("");
                showStack();
                getTotal();
                console.log(data);
            }).catch(error => {
                console.error("There was some error during sent the data", error);
            });
    });

    $('#remove').click(function () {
        $.ajax({
            url: "api/v1/shopping-cart/remove",
            type: 'DELETE',
            success: function (response) {
                showStack();
                getTotal();
                console.log(response);
            },
            error: function (xhr, status, error) {
                console.log(xhr.responseText);
                showStack();
                getTotal();
            }
        });
    });
});

function showStack() {
    $(".content").empty();
    fetch("/api/v1/shopping-cart/get-products")
        .then(response => response.json())
        .then(data => {
            for (var i = 0; i < data.length; i++) createProduct(data[i].name, data[i].weight);
        })
        .catch(error => {
            console.error('Error:', error);
        })
}
function createProduct(product, weight) {
    newProduct = product.replace(/[+=]/g, " ");
    var product = $('<div>', { class: 'row stack p-2 mb-2', text: newProduct + " (" + weight + "kg)" });
    $(".content").append(product)
}
function getTotal() {
    fetch("api/v1/shopping-cart/get-total")
        .then(response => response.json())
        .then(data => {
            $("#total").html(data + "Kg");
            $("#price").html((data * 350) + "Kz");
        })
        .catch(error => {
            console.error('Error:', error);
        })
}