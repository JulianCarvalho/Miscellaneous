<?php
    $portfolio = [ "AMZN" => [25,1760.19,"Amazon.com Inc."],
    "APPL" => [20,218.32,"Apple Inc."],
    "MSFT" => [15,108.82,"Microsoft Corporation"],
    "GOOGL" => [40,1111.39,"Alphabet Inc."]
    ];
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>  
    <title>Lab 12</title>   
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,800" rel="stylesheet">    
    <link rel="stylesheet" href="css/lab12-ex04.css">
</head>
<body>
<main class="container">

    <div class="box"> 
        <h1>Portfolio Overview</h1>
        <div class="data">
            <?php
            foreach ($portfolio as $key => $value) {
                echo "<h2>$key</h2>";
                echo "<h3>$value[2]</h3>";
                echo "<p>$value[0]% at $" . $value[1] . "</p>";
            }
?>
</div>
    </div>

</main>   
</body>
</html>