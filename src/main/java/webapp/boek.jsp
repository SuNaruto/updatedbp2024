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
                <h1 style="color: #fff;">Books Overview</h1>
            </div>
            <div class="col-md-6 text-md-end">
                <button id="createBookBtn" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#createBookModal">Create Book</button>
            </div>
        </div>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody id="booksTableBody"></tbody>
        </table>

        <button class="btn btn-primary" onclick="goToIndex()">Back to Index</button>
    </div>

    <!-- Edit Book Modal -->
    <div class="modal" id="editBookModal" tabindex="-1" role="dialog">
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
                    <form id="editBookForm">
                        <div class="form-group">
                            <label for="editTitle">Title:</label>
                            <input type="text" class="form-control" id="editTitle" name="editTitle" required>
                        </div>
                        <div class="form-group">
                            <label for="editAuthor">Author:</label>
                            <input type="text" class="form-control" id="editAuthor" name="editAuthor" required>
                        </div>
                        <div class="form-group">
                            <label for="editAantal">Quantity:</label>
                            <input type="number" class="form-control" id="editAantal" name="editAantal" required>
                        </div>
                        <input type="hidden" id="editBookID">
                        <button type="button" class="btn btn-primary" onclick="saveBookChanges()">Update</button>
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

    <!-- Create Book Modal -->
    <div class="modal" id="createBookModal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Create Book</h5>
                    <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Book create form -->
                    <form id="createBookForm">
                        <div class="form-group">
                            <label for="createTitle">Title:</label>
                            <input type="text" class="form-control" id="createTitle" name="titel" required>
                        </div>
                        <div class="form-group">
                            <label for="createAuthor">Author:</label>
                            <input type="text" class="form-control" id="createAuthor" name="auteur" required>
                        </div>
                        <div class="form-group">
                            <label for="createAantal">Quantity:</label>
                            <input type="number" class="form-control" id="createAantal" name="aantal" required>
                        </div>
                        <button type="button" class="btn btn-success" onclick="saveBook()">Save</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div id="alertPlaceholder"></div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="boek.js"></script>
    <script>
        function goToIndex() {
            window.location.href = 'http://localhost:8080/api/';
        }
    </script>
</body>
</html>
