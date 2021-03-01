<?php
$symbols = array("ADBE","APPL","ATVI","AMZN","ADSK","FB","GOOGL","MSFT");
$names = ["Adobe Systems Inc.","Apple Inc.", "Activision Blizzard","Amazon.com Inc.", "Autodesk Inc.","Facebook Inc.", "Alphabet Inc.","Microsoft Corporation"];
$prices = [240.36,218.32,75.42,1760.19,135.25,154.62,1111.39,108.82];

function outputStocks($symbols, $names, $prices) {
    for ($i=0; $i < count($symbols); $i++) {
    echo "<div class='box'>";
    echo "<h2>$symbols[$i]</h2>";
    echo "<h3>$names[$i]</h3>";
    echo "<p>$$prices[$i]</p>";
    echo "</div>";
    }
}
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>  
    <title>Lab 12</title>   
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,800" rel="stylesheet">    
    <link rel="stylesheet" href="css/lab12-ex01.css">
</head>
<body>
<main class="container">
    <div class="grid-container">
    <?php outputStocks($symbols, $names, $prices); ?>
    </div>
</main>   
</body>
</html>