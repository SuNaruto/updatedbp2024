// Functie om boeken op te halen van de server
function fetchBoeken() {
    fetch('http://localhost:8080/api/library/boek/all')
        .then(response => response.json())
        .then(data => displayBoeken(data))
        .catch(error => console.error('Fout bij het ophalen van boeken:', error));
}

// Functie om de tabel te vullen met boeken
function displayBoeken(boeken) {
    var tableBody = $('#booksTableBody');
    tableBody.empty(); // Leeg de tabel voordat je de boeken toevoegt

    boeken.forEach(function(boek) {
        var row = '<tr>' +
            '<td>' + boek.boek_id + '</td>' +
            '<td>' + boek.titel + '</td>' +
            '<td>' + boek.auteur + '</td>' +
            '<td>' + boek.aantal + '</td>' +
            '<td>' +
                '<button class="btn btn-warning btn-sm" onclick="editBook(' + boek.boek_id + ')">Edit</button> ' +
                '<button class="btn btn-danger btn-sm" onclick="deleteBook(' + boek.boek_id + ')">Delete</button>' +
            '</td>' +
            '</tr>';
        tableBody.append(row);
    });
}

// Functie om een boek te verwijderen
function deleteBook(bookID) {
    $('#confirmationModal').modal('show');
    $('#confirmDeleteBtn').off('click').on('click', function () {
        $('#confirmationModal').modal('hide');
        $.ajax({
            url: 'http://localhost:8080/api/library/boek/delete/' + bookID,
            method: 'DELETE',
            success: function () {
                showAlert('Book deleted successfully!', 'success');
                setTimeout(fetchBoeken, 500); // Ververs de lijst na de verwijdering
            },
            error: function (xhr, status, error) {
                console.error('Error deleting book:', error);
                showAlert('Failed to delete the book. Please try again!', 'danger');
            }
        });
    });
}

// Functie om een boek te bewerken
function editBook(bookID) {
    $.ajax({
        url: 'http://localhost:8080/api/library/boek/get/' + bookID,
        method: 'GET',
        dataType: 'json',
        success: function (book) {
            $('#editBookID').val(book.boek_id);
            $('#editTitle').val(book.titel);
            $('#editAuthor').val(book.auteur);
            $('#editBookModal').modal('show');
            $('#saveChangesBtn').off('click').on('click', function () {
                saveBookChanges(book.id);

            });
        },
        error: function (xhr, status, error) {
            console.error('Error fetching Book for edit:', error);
        }
    });
}

// Functie om boekwijzigingen op te slaan
function saveBookChanges(bookID) {
    var updatedData = {
        boek_id: $('#editBookID').val(),
        titel: $('#editTitle').val(),
        auteur: $('#editAuthor').val(),
        aantal: parseInt($('#editAantal').val(), 10)
    };

    $.ajax({
        url: 'http://localhost:8080/api/library/boek/update',
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedData),
        success: function() {
            showAlert('Book updated successfully!', 'success');
            $('#editBookModal').modal('hide'); // Sluit de modal

            // Direct na het verbergen van de modal, de lijst opnieuw ophalen
            // We wachten niet op het 'hidden' event om te verzekeren dat het onmiddellijk wordt uitgevoerd
            fetchBoeken();
        },
        error: function(xhr, status, error) {
            console.error('Error updating book:', error);
            showAlert('Failed to update the book. Please try again!', 'danger');
        }
    });
}




// Functie om een nieuw boek op te slaan
function saveBook() {
    var newData = {
        titel: $('#createTitle').val(),
        auteur: $('#createAuthor').val(),
        aantal: parseInt($('#createAantal').val(), 10)
    };

    $.ajax({
        url: 'http://localhost:8080/api/library/boek/add',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(newData),
        success: function(data) {
            $('#createBookModal').modal('hide');
            showAlert('Book saved successfully!', 'success');
            setTimeout(fetchBoeken, 500); // Ververs de lijst na het toevoegen van een nieuw boek
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            showAlert('Failed to save the book. Please try again!', 'danger');
        }
    });
}

// Functie om alerts te tonen
function showAlert(message, type) {
    var alertPlaceholder = $('#alertPlaceholder');
    var alert = $('<div class="alert alert-' + type + ' alert-dismissible fade show" role="alert">' + message + '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
    alertPlaceholder.append(alert);
    setTimeout(function() {
        alert.alert('close');
    }, 5000);
}

$(document).ready(function() {
    setTimeout(fetchBoeken, 500); // Ververs de lijst na de verwijdering;
});
