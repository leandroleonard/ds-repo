$(document).ready(function () {
    showStart();
    showEnd();
    $('#form-add').submit(function (event) {
        event.preventDefault();

        const destination = $("#form-add-destination").val();
        const nearby = $("#form-add-nearby").val();

        const formData = {
            local: destination,
            closeness: nearby
        };

        fetch("/api/v1/graph/add", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(formData)
        })
            .then(response => response.text())
            .then(data => {
                $(".bs-modal-add").modal("hide");
                $("#form-add-destination").val("");
                $("#form-add-nearby").val("");
                showStart();
                showEnd();
                console.log(data);
            })
            .catch(error => {
                console.error("There was some error during sent the data", error);
            });
    });

    $('#form-calculate').submit(function (event) {
        event.preventDefault();

        const startValue = $('input[name="starter"]:checked').val();
        const endValue = $('input[name="arrived"]:checked').val();

        if (startValue && endValue) {
            const formData = {
                local: startValue,
                closeness: endValue
            };

            fetch("api/v1/graph/calculate", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(formData)
            })
                .then(resposne => resposne.json())
                .then(data => {
                    $("#shorterRoot").text(data);
                }).catch(error => {
                    console.error("There was some error during sent the data", error);
                });
        } else {
            alert('You need to specify the starter and the ended.');
        }
    });
});

function showStart() {
    $(".content").empty();
    fetch("/api/v1/graph/display")
        .then(response => response.json())
        .then(data => {
            data.forEach(function (item) {
                var radio = $('<input>').attr({
                    type: 'radio',
                    name: 'starter',
                    value: item
                });

                var label = $('<label>').text(item);

                $('#starter').append(radio, label, '<br>');
            });
        })
        .catch(error => {
            console.error('Error:', error);
        })
}

function showEnd() {
    $(".content").empty();
    fetch("/api/v1/graph/display")
        .then(response => response.json())
        .then(data => {
            data.forEach(function (item) {
                var radio = $('<input>').attr({
                    type: 'radio',
                    name: 'arrived',
                    value: item
                });

                var label = $('<label>').text(item);

                $('#arrived').append(radio, label, '<br>');
            });
        })
        .catch(error => {
            console.error('Error:', error);
        })
}