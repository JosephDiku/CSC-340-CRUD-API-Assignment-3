<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel ="stylesheet" href="/css/style.css">
    <title>Update Animal</title>
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
        <h2>Update Animal</h2>

        <div style="text-align:center; margin-bottom:1rem;">
            <#if animal.image?? && animal.image?has_content>
                <img src="${animal.image}" alt="${animal.name!'Animal Image'}" style="max-width:320px; height:auto; border-radius:8px;">
            </#if>
        </div>

        <form action="update-animal" method="post">
            <input type="hidden" name="id" value="${animal.id?c}">

            <label for="name">Animal Name:</label>
            <input type="text" id="name" name="name" value="${animal.name!''}" required>

            <label for="type">Type:</label>
            <input type="text" id="type" name="type" value="${animal.type!''}" required>

            <label for="description">Short Description:</label>
            <textarea id="description" name="description" rows="4" required>${animal.description!''}</textarea>

            <label for="image">Image URL:</label>
            <input type="url" id="image" name="image" value="${animal.image!''}">

            <div style="display:flex; gap:.5rem; flex-wrap:wrap; margin-top:.75rem;">
                <button type="submit">Save Changes</button>
                <a href="index.html"><button type="button">Cancel</button></a>
            </div>
        </form>
    </div>

</body>
</html>
