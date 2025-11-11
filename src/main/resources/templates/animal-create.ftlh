<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel ="stylesheet" href="/css/style.css">
</head>

<body>

    <div>
        <a href="index.html">
            <h1>Animal Gallery</h1>
        </a>
    </div>

    <nav class="navbar">
        <a href="index.html">Home</a>
        <a href="about.html">About</a>
        <a href="new-animal-form.html">Add Animal</a>
    </nav>

    <div class="form-container">
        <h2>Add a New Animal</h2>
        <form action="#" method="post">
            <label for="name">Animal Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter animal name" required>

            <label for="type">Type:</label>
            <input type="text" id="type" name="type" placeholder="e.g., Mammal, Bird, Amphibian" required>

            <label for="description">Short Description:</label>
            <textarea id="description" name="description" rows="4" placeholder="Write a short description of the animal..." required></textarea>

            <label for="image">Image URL:</label>
            <input type="url" id="image" name="image" placeholder="http://example.com/animal.jpg">

            <button type="submit">Submit</button>
        </form>
    </div>

</body>
</html>