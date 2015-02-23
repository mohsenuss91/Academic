

<?php


//tester le champs du form
if 
(
	(isset($_POST['email']) && !empty($_POST['email']))
	AND(isset($_POST['password']) && !empty($_POST['password']))
	AND(isset($_POST['confpassword']) && !empty($_POST['confpassword']))
	AND(isset($_POST['nom']) && !empty($_POST['nom']))
	AND(isset($_POST['prenom']) && !empty($_POST['prenom']))
	AND(isset($_POST['sexe']) && !empty($_POST['sexe']))
	AND(isset($_POST['age']) && !empty($_POST['age']))
	AND(isset($_POST['brotherandsister']) && !empty($_POST['brotherandsister']))
	AND(isset($_POST['classbrotherandsister']) && !empty($_POST['classbrotherandsister']))
	AND(isset($_POST['vue']) && !empty($_POST['vue']))
	AND(isset($_POST['audition']) && !empty($_POST['audition']))
)
{

//recuperation des variables

$email=$_POST['email'];
$password=$_POST['password'];
$confpassword=$_POST['confpassword'];
$nom=$_POST['nom'];
$prenom=$_POST['prenom'];
$sexe=$_POST['sexe'];
$age=$_POST['age'];
$brotherandsister=$_POST['brotherandsister'];
$classbrotherandsister=$_POST['classbrotherandsister'];
$vue=$_POST['vue'];
$audition=$_POST['audition'];

/*variable session
session_start();
$_SESSION=['email']=$_POST['email'];
$_SESSION['password']=$_POST['password'];
$_SESSION['confpassword']=$_POST['confpassword'];
$_SESSION['nom']=$_POST['nom'];
$_SESSION['prenom']=$_POST['prenom'];
$_SESSION['sexe']=$_POST['sexe'];
$_SESSION['age']=$_POST['age'];
$_SESSION['brotherandsister']=$_POST['brotherandsister'];
$_SESSION['classbrotherandsister']=$_POST['classbrotherandsister'];
$_SESSION['vue']=$_POST['vue'];
$_SESSION['audition']=$_POST['audition'];
*/

// username and password sent from Form 

// tester le mot de passe
	if ($password != $confpassword) 
		{echo "<h3>الرجاء منكم التأكد من تطابق كلمة السر </h3>";}
	else{

			//connexion a la bdd 
				include('connex_bdd.php');

			//tester lexistence du membre
			 

				$sql="SELECT * FROM members WHERE email='$email'";
				$result=$con->query($sql);
 
				$count=$result->rowCount();
	
				echo "<h1>$count</h1></br>";
				if ($count==0)
				{
					
					
					$q2=$con->query("INSERT INTO members (email, password, familyname, firstname, sexe, age, broandsis, classbroandsis, view, hearing, date_insc)
					VALUES ('$email','$password','$nom','$prenom','$sexe',$age,$brotherandsister,$classbrotherandsister,'$vue','$audition',NOW())");

				

					echo "<h3>لقد تم تسجيلك بنجاح</h1>";
					header("location: index.php");

					mysqli_close($con);
				}
				else
				{
					echo"<h3>نحن آسفون البريد الاكتروني محجوز, الرجاء منكم اختيار عنوان آخر للتسجيل .</h3>";
				}


}

}
else 
{

echo"<h3>الرجاء التأكد من ملأ البيانات التالية</h3>";
		if (empty($_POST['email'])){echo"<h3>البريد الالكتروني</h3>";}
		if (empty($_POST['password'])){echo"<h3>كلمة السر</h3>";}
		if (empty($_POST['nom'])){echo"<h3>اللقب</h3>";}
		if (empty($_POST['prenom'])){echo"<h3>الاسم</h3>";}
		if (empty($_POST['sexe'])){echo"<h3>الجنس</h3>";}
		if (empty($_POST['age'])){echo"<h3>العمر</h3>";}
		if (empty($_POST['brotherandsister'])){echo"<h3>عدد الاخوة و الاخوات</h3>";}
		if (empty($_POST['classbrotherandsister'])){echo"<h3>ترتيبك في العائلة</h3>";}
		if (empty($_POST['vue'])){echo"<h3>النظر</h3>";}
		if (empty($_POST['audition'])){echo"<h3>السمع</h3>";}
}
	

?>


