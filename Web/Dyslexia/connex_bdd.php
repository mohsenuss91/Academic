<?php

try
{
	$con = new PDO('mysql:host=localhost;dbname=dyslexia', 'root', '');
	$con->exec("set names utf8");
}
catch (Exception $e)
{
        die('Erreur : ' . $e->getMessage());
}


?>
