<!DOCTYPE html>
<html lang="en">

<header>
    <img src="tech.jpg" alt="Logo">



<nav>
              <a href="index.jsp">Home</a>
              <a href="boek.jsp">Books</a>
              <a href="user.jsp">Users</a>
              <a href="uitlening.jsp">Uitlening</a>
              <a href="about.jsp">About</a>
    </nav>
</header>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Overview</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="book.css">
</head>

<body>

<div class="container">
<div class="row">
    <div class="col-md-6">
        <h1 style="color: #fff;">User Overview</h1>
    </div>
    <div class="col-md-6 text-md-end">
        <button id="createUserBtn" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#createUserModal">Create User</button>
    </div>

</div>


    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>naam</th>
            <th>adres</th>
            <th>telefoonnummer</th>

        </tr>
        </thead>
        <tbody id="UsersTableBody"></tbody>
    </table>

    <button class="btn btn-primary" onclick="goToIndex()">Back to Index</button>
</div>

<!-- Edit User Modal -->
<div class="modal" id="editUserModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document"> <!-- Add this line for consistency -->
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit User</h5>
                <!-- Use the Bootstrap 5 close button for consistency -->
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editUserForm">
                    <div class="form-group">
                        <label for="editNaam">Naam:</label>
                        <input type="text" class="form-control" id="editNaam" name="editNaam" required>
                    </div>
                    <div class="form-group">
                        <label for="editAdres">Adres:</label>
                        <input type="text" class="form-control" id="editAdres" name="editAdres" required>
                    </div>
                    <div class="form-group">
                        <label for="editTelefoonnummer">Telefoonnummer:</label>
                        <input type="number" class="form-control" id="editTelefoonnummer" name="editTelefoonnummer" required>
                    </div>
                    <input type="hidden" id="editLidID">
                    <button type="button" class="btn btn-primary" onclick="saveLidChanges()">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>




<!-- Confirmation Modal -->
<div class="modal fade" id="confirmationModal" tabindex="-1" role="dialog" aria-labelledby="confirmationModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="confirmationModalLabel">Confirm Deletion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Are you sure you want to delete this Book?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" id="confirmDeleteBtn">Delete</button>
            </div>
        </div>
    </div>
</div>

<div id="alertPlaceholder"></div>
<!-- Create User Modal -->
<div class="modal" id="createUserModal" tabindex="-1" aria-labelledby="createUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createUserModalLabel">Create User</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- User create form -->
                <form id="createUserForm">
                    <div class="form-group">
                            <label for="createNaam">Naam:</label>
                            <input type="text" class="form-control" id="createNaam" name="naam" required>
                        </div>
                        <div class="form-group">
                            <label for="createAdres">Adres:</label>
                            <input type="text" class="form-control" id="createAdres" name="adres" required>
                        </div>
                        <div class="form-group">
                            <label for="createTelefoonnummer">Telefoonnummer:</label>
                            <input type="text" class="form-control" id="createTelefoonnummer" name="telefoonnummer" required>
                        </div>
                    <!-- Submit button -->
                    <button type="button" class="btn btn-success" onclick="saveLid()">Save</button>
                </form>
            </div>
        </div>
    </div>
</div>





<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="lid.js"></script>
<script src="https://cdn.jsdelivr.net/npm/mixpanel-browser@latest/dist/mixpanel.min.js"></script>

<script>
    function goToIndex() {
        window.location.href = 'http://localhost:8080/api/library';
    }
</script>

</body>

</html>
