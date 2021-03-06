<?php
include('includes/lab12-test01.inc.php');

function makeBox($weatherData, $key){
    $temp = $weatherData[$key][0];
    $precip = ucfirst($weatherData[$key][1]);
    $array = $weatherData[$key][2];

    echo "<article class='box'> <h1>$key</h1><div class='weather'><img src='images/$key.jpg'/><div><h2>$temp</h2><p>$precip</p></div></div><section>";
    foreach($array as $key2 => $value2){dayCast($array, $key2);}
    echo "</section></article>";
}

function dayCast($array, $key2){
    $temp = $array[$key2][0];
    $precip = $array[$key2][1];

    echo "<div><h3>$key2</h3><p><i class='wi wi-day-".$array[$key2][1]."'></i></p><p>".$array[$key2][0]."</p></div>";
}
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>  
    <title>Lab 12</title>   
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,800" rel="stylesheet">   
    <link rel="stylesheet" href="css/weather-icons.min.css">
        
    <link rel="stylesheet" href="css/lab12-test01.css">
</head>
<body>
<main class="grid-container">

    <?php 
    foreach($weatherData as $key => $value){makeBox($weatherData, $key);}
    ?>
<!--     <article class="box"> 
        <h1>Chicago</h1>
        
        <div class="weather">
            <img src="images/Chicago.jpg"  />
            <div>
                <h2>45</h2>
                <p>Fog</p>                
            </div>
        </div>
        <section>
            <div>
                <h3>Mon</h3>
                <p><i class="wi wi-day-fog"></i></p>
                <p>44</p>
            </div>
            <div>
                <h3>Tue</h3>
                <p><i class="wi wi-day-sleet"></i></p>
                <p>42</p>
            </div>   
            <div>
                <h3>Wed</h3>
                <p><i class="wi wi-day-rain"></i></p>
                <p>40</p>
            </div>  
            <div>
                <h3>Thu</h3>
                <p><i class="wi wi-day-cloudy"></i></p>
                <p>44</p>
            </div>
            <div>
                <h3>Fri</h3>
                <p><i class="wi wi-day-cloudy"></i></p>
                <p>45</p>
            </div>            
        </section>
    </article>
    
    
    <article class="box"> 
        <h1>Paris</h1>
        
        <div class="weather">
            <img src="images/Paris.jpg"  />
            <div>
                <h2>73</h2>
                <p>Sunny</p>                
            </div>
        </div>
        <section>
            <div>
                <h3>Mon</h3>
                <p><i class="wi wi-day-sunny"></i></p>
                <p>75</p>
            </div>
            <div>
                <h3>Tue</h3>
                <p><i class="wi wi-day-sunny"></i></p>
                <p>75</p>
            </div>   
            <div>
                <h3>Wed</h3>
                <p><i class="wi wi-day-cloudy"></i></p>
                <p>68</p>
            </div>  
            <div>
                <h3>Thu</h3>
                <p><i class="wi wi-day-cloudy"></i></p>
                <p>66</p>
            </div>
            <div>
                <h3>Fri</h3>
                <p><i class="wi wi-day-rain"></i></p>
                <p>60</p>
            </div>            
        </section>
    </article>   
    
    <article class="box"> 
        <h1>Calgary</h1>
        
        <div class="weather">
            <img src="images/Calgary.jpg"  />
            <div>
                <h2>-8</h2>
                <p>Snow</p>                
            </div>
        </div>
        <section>
            <div>
                <h3>Mon</h3>
                <p><i class="wi wi-day-snow"></i></p>
                <p>-7</p>
            </div>
            <div>
                <h3>Tue</h3>
                <p><i class="wi wi-day-snow"></i></p>
                <p>-10</p>
            </div>   
            <div>
                <h3>Wed</h3>
                <p><i class="wi wi-day-sleet"></i></p>
                <p>-3</p>
            </div>  
            <div>
                <h3>Thu</h3>
                <p><i class="wi wi-day-cloudy"></i></p>
                <p>0</p>
            </div>
            <div>
                <h3>Fri</h3>
                <p><i class="wi wi-day-sunny"></i></p>
                <p>3</p>
            </div>            
        </section>
    </article>  -->    

</main>   
</body>
</html>