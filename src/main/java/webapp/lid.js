// Functie om leden op te halen van de server
function fetchLeden() {
    fetch('http://localhost:8080/api/library/lid/all')
        .then(response => response.json())
        .then(data => displayLeden(data))
        .catch(error => console.error('Fout bij het ophalen van leden:', error));
}

// Functie om de tabel te vullen met leden
function displayLeden(leden) {
    var tableBody = $('#UsersTableBody');
    tableBody.empty(); // Leeg de tabel voordat je de leden toevoegt

    leden.forEach(lid => {
        var row = `<tr>
            <td>${lid.lid_id}</td>
            <td>${lid.naam}</td>
            <td>${lid.adres}</td>
            <td>${lid.telefoonnummer}</td>
            <td>
                <button class="btn btn-warning btn-sm" onclick="editLid(${lid.lid_id})">Edit</button>
                <button class="btn btn-danger btn-sm" onclick="deleteLid(${lid.lid_id})">Delete</button>
            </td>
        </tr>`;
        tableBody.append(row);
    });
}

// Functie om een lid te bewerken
function editLid(lidID) {
    fetch(`http://localhost:8080/api/library/lid/get/${lidID}`)
        .then(response => response.json())
        .then(lid => {
            $('#editLidID').val(lid.lid_id);
            $('#editNaam').val(lid.naam);
            $('#editAdres').val(lid.adres);
            $('#editTelefoonnummer').val(lid.telefoonnummer);
            $('#editUserModal').modal('show');
        })
        .catch(error => console.error('Error fetching Lid for edit:', error));
}

// Functie om lidwijzigingen op te slaan
function saveLidChanges() {
    var updatedData = {
        lid_id: $('#editLidID').val(),
        naam: $('#editNaam').val(),
        adres: $('#editAdres').val(),
        telefoonnummer: $('#editTelefoonnummer').val()
    };

    fetch('http://localhost:8080/api/library/lid/update', {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updatedData)
    })
    .then(() => {
        $('#editUserModal').modal('hide');
        showAlert('Lid updated successfully!', 'success');
        fetchLeden();
    })
    .catch(error => {
        console.error('Error updating lid:', error);
        showAlert('Failed to update the lid. Please try again!', 'danger');
    });
}

// Functie om een nieuw lid op te slaan
function saveLid() {
    var newData = {
        naam: $('#createNaam').val(),
        adres: $('#createAdres').val(),
        telefoonnummer: $('#createTelefoonnummer').val()
    };

    $.ajax({
        url: 'http://localhost:8080/api/library/lid/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(newData),
        success: function(data) {
            $('#createUserModal').modal('hide');
            showAlert('Lid saved successfully!', 'success');
            setTimeout(fetchLeden, 500); // Ververs de lijst na het toevoegen van een nieuw lid
        },
        error: function(xhr, status, error) {
            console.error('Error saving lid:', error);
            showAlert('Failed to save the lid. Please try again!', 'danger');
        }
    });
}

// Functie om een lid te verwijderen
function deleteLid(lidID) {
    if(confirm('Are you sure you want to delete this lid?')) {
        fetch(`http://localhost:8080/api/library/lid/delete/${lidID}`, { method: 'DELETE' })
        .then(() => {
            showAlert('Lid deleted successfully!', 'success');
            fetchLeden();
        })
        .catch(error => {
            console.error('Error deleting lid:', error);
            showAlert('Failed to delete the lid. Please try again!', 'danger');
        });
    }
}

// Functie om alerts te tonen
function showAlert(message, type) {
    var alertPlaceholder = $('#alertPlaceholder');
    var alert = $(`<div class="alert alert-${type} alert-dismissible fade show" role="alert">${message}<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>`);
    alertPlaceholder.append(alert);
    setTimeout(() => { alert.alert('close'); }, 5000);
}

$(document).ready(function() {
    fetchLeden();
});
