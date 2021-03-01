<?php
    // we need to tell browser that this is returning an image
    header('Content-Type: image/png');

    // create a 500x500 image
    $img = imagecreatetruecolor(500,500);

    // fill this image with a RGB defined color
    $color = imagecolorallocate($img,238,71,49);

    // fill the entirety of this image with the color
    imagefilledrectangle($img, 0, 0, 499, 499, $color);

    // output the image to the response stream (back to the browser)
    imagepng($img);

    $fontFile = realpath('font/Lato-Medium.ttf');
    $fontSize = 24;
    $textColor = imagecolorallocate($img,238,238,238);
    imagettftext($img,$fontSize,0,50,230,$textColor,$fontFile,"Something Witty"); 
?> 