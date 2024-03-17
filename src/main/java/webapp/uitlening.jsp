<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Overview</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="book.css">
</head>
<body>
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

    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1 style="color: #fff;">Uitlening Overview</h1>
            </div>
            <div class="col-md-6 text-md-end">
                <button id="createBookBtn" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#createUitleningModal">Create Uitlening</button>
            </div>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>User</th>
                    <th>Boek</th>
                    <th>Uitlening</th>
                    <th>Terug gebracht</th>
                </tr>
            </thead>
            <tbody id="UitleningTableBody"></tbody>
        </table>

        <button class="btn btn-primary" onclick="goToIndex()">Back to Index</button>
    </div>

    <!-- Edit Book Modal -->
    <div class="modal" id="editUitleningModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Edit Book</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                 <!-- Book edit form -->
                    <form id="editUitleningForm">
                        <div class="form-group">
                            <label for="editNaam">Naam:</label>
                            <input type="text" class="form-control" id="editNaam" name="editNaam" required>
                        </div>
                        <div class="form-group">
                            <label for="editBoek">Boek:</label>
                            <input type="text" class="form-control" id="editBoek" name="editBoek" required>
                        </div>
                        <div class="form-group">
                            <label for="editUitlening">Uitlening:</label>
                            <input type="number" class="form-control" id="editUitlening" name="editUitlening" required>
                        </div>
                          <div class="form-group">
                             <label for="editTerugGebracht">Terug Gebracht:</label>
                             <input type="number" class="form-control" id="editTerugGebracht" name="editTerugGebracht" required>
                                                </div>
                        <input type="hidden" id="uitleningID">
                        <button type="button" class="btn btn-primary" onclick="saveUitleningChanges()">Update</button>
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
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Are you sure you want to delete this Book?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger" id="confirmDeleteBtn">Delete</button>
                </div>
            </div>
        </div>
    </div>

   <!-- Create Uitlening Modal -->
   <div class="modal" id="createUitleningModal" tabindex="-1" role="dialog">
       <div class="modal-dialog" role="document">
           <div class="modal-content">
               <div class="modal-header">
                   <h5 class="modal-title">Create Uitlening</h5>
                   <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
               </div>
               <div class="modal-body">
                   <form id="createUitleningForm">
                       <div class="form-group">
                           <label for="createNaam">Gebruiker:</label>
                           <select class="form-control" id="createNaam" name="createNaam" required>
                               <!-- Opties worden hier dynamisch toegevoegd -->
                           </select>
                       </div>
                       <div class="form-group">
                           <label for="createBoek">Boek:</label>
                           <select class="form-control" id="createBoek" name="createBoek" required>
                               <!-- Opties worden hier dynamisch toegevoegd -->
                           </select>
                       </div>
                       <div class="form-group">
                           <label for="createUitlening">Uitlening:</label>
                           <input type="date" class="form-control" id="createUitlening" name="createUitlening" required>
                       </div>
                       <button type="button" class="btn btn-success" onclick="saveUitlening()">Save</button>
                   </form>
               </div>
           </div>
       </div>
   </div>


    <div id="alertPlaceholder"></div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="uitlening.js"></script>
    <script>
        function goToIndex() {
            window.location.href = 'http://localhost:8080/api/';
        }
    </script>
</body>
</html>
