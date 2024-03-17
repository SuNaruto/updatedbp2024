<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Our Library Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="book.css"> <!-- Pas de naam van je CSS-bestand aan indien nodig -->
</head>
<body>
    <header class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="index.jsp">
                <img src="tech.jpg" alt="Library Logo" style="height: 30px;"> <!-- Pas de src aan naar je daadwerkelijke logo URL -->
            </a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="boek.jsp">Books</a></li>
                    <li class="nav-item"><a class="nav-link" href="user.jsp">Users</a></li>
                    <li class="nav-item"><a class="nav-link" href="uitlening.jsp">Uitlening</a></li>
                    <li class="nav-item"><a class="nav-link" href="about.jsp">About</a></li>
                </ul>
            </div>
        </div>
    </header>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8 text-center">
                <h1>Welcome to Our Library Management System</h1>
                <p class="mt-4">Explore our vast collection of books.</p>
                <img src="library.jpg" class="img-fluid" alt="Library Image"> <!-- Pas de src aan naar je daadwerkelijke afbeelding URL -->
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
