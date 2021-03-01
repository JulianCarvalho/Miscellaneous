<?php
function displayPostStatus() {
    if (isset($_POST['something']) && $_POST['something']!="") { 
        echo "Your content was: " . $_POST["something"];
    }
    else{
        echo "No Post Detected";
    }
   }
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>  
    <title>Lab 12</title>   
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,800" rel="stylesheet">    
    <link rel="stylesheet" href="css/lab12-ex05.css">
</head>
<body>
<main class="container">

    <section class="box"> 
        <h1>Sample Form</h1>
        <form method=post action=lab12-ex05.php>
             <label>Enter something: </label> <input type='text' name='something' />
             <input type='submit' value='Post' />            
        </form>
        <div id="messages">
            <?php displayPostStatus();?> 
        </div>
    </section>

</main>   
</body>
</html>