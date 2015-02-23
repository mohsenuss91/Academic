<?php

function hamming($a,$b) 
{

 $sa=count($a);
 $sb=count($b);
 $h=0;

 	if ($sa==$sb) 
	{
		for ($i=0; $i < $sa; $i++) 
		{ 
			if ($a[$i]!=$b[$i]) 
			{
				$h++;
			}
		}

	}
 return $h;
}





if
(	
	(isset($_POST['quest1']) && !empty($_POST['quest1']))
	AND(isset($_POST['quest2']) && !empty($_POST['quest2']))
	AND(isset($_POST['quest3']) && !empty($_POST['quest3']))
	AND(isset($_POST['quest4']) && !empty($_POST['quest4']))
)
{
$rep[]=$_POST['quest1'];
$rep[]=$_POST['quest2'];
$rep[]=$_POST['quest3'];
$rep[]=$_POST['quest4'];

$sur=count($rep);

echo "<h3>احتمال اصابتك بعسر القراءة</h3>";
$resultat=hamming($model,$rep);

$resultsfinal=$resultat/$sur*100;
echo "<h1>$resultsfinal%</h1>";
//header("Location:http://localhost/Dyslexie/quiz.php#results");

}
else 
{
echo "<h2>عليك بملأ الاجابات كاملة</h2>";
}



?>