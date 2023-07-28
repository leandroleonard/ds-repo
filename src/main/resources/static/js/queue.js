$(document).ready(function () {
    showQueue();
    $('#form-add').submit(function (event) {
        event.preventDefault();

        const name = $("#form-add-name").val();
        
        const formData = {name: name, priority: false};
        
        fetch("/api/v1/care-line/add-patient", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        })
            .then(response => response.text())
            .then(data => {
                $(".bs-modal-add").modal("hide");
                $("#form-add-name").val("");
                showQueue();
                console.log(data);
            })
            .catch(error => {
                console.error("There was some error during sent the data", error);
            });
    });

    $('#form-add-priority').submit(function (event) {
        event.preventDefault();

        var name = $("#form-add-name-priority").val();
        
        const formData = {name: name, priority: true};

        fetch("api/v1/care-line/add-priority-patient", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        })
            .then(response => response.text())
            .then(data => {
                $(".bs-modal-add-priority").modal("hide");
                $("#form-add-name-priority").val("");
                console.log(data);
                showQueue();
            })
            .catch(error => {
                console.error("There was some error during the operation", error);
            });
    });



    $('#remove').click(function () {
        $.ajax({
            url: "/api/v1/care-line/attend-patient",
            type: 'DELETE',
            success: function (response) {
                console.log(response)
                showQueue();
            },
            error: function (xhr, status, error) {
                console.log(xhr.responseText)
            }
        });
    });
});

function showQueue() {
    $(".content").empty();
    fetch("/api/v1/care-line/get-all-patients")
        .then(response => response.json())
        .then(data => {
            for (var i = 0; i < data.length; i++) createPerson(data[i].name, data[i].priority);
        })
        .catch(error => {
            console.log("Error:" + error);
        })
}

function createPerson(name, priority) {
    newName = name.replace(/[+=]/g, " ");
    if (priority == false) {
        var person = $('<div>', { class: 'col-md-3 queue p-2 mb-2', text: newName });
        $(".content").append(person)
    } else {
        var person = $('<div>', { class: 'col-md-3 priority-queue p-2 mb-2', text: newName });
        $(".content").append(person)
    }
}