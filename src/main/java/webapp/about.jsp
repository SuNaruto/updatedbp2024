
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #017BFF;
            padding: 20px 20px; /* Added padding to the left and right */
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding-left: 60px;
            padding-right: 60px;
        }

        header img {
            max-height: 50px;
        }

        nav {
            display: flex;
            gap: 20px;
        }

        nav a {
            text-decoration: none;
            color: #fff;
            font-weight: bold;
        }

        section {
            padding: 20px;
            display: flex;
            align-items: center;
            justify-content: center; /* Center content horizontally */
            box-sizing: border-box; /* Include padding in width calculation */
        }

        section img {
            max-width: 50%;
            border-radius: 8px;
            margin-right: 20px;
        }

        section div {
            max-width: 50%;
        }

        section div p {
            margin-top: 0;
        }

        footer {
            background-color: lightgray;
            color: #333;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<header>
    <img src="tech.jpg" alt="Logo">

    <nav>
              <a href="index.jsp">Home</a>
              <a href="index.jsp">Books</a>
              <a href="user.jsp">Users</a>
              <a href="uitlening.jsp">Uitlening</a>
              <a href="about.jsp">About</a>
    </nav>
</header>

<section>
    <img src="the end.jpg" alt="About Image">
    <div>
        <h2>About Us</h2>
        <h1>The End.</h1>
    </div>
</section>

