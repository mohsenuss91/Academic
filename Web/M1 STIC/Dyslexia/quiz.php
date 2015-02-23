<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE HTML>
<!--
	Miniport 2.5 by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>


		<?php 
  			// Send a raw HTTP header 
  			header ('Content-Type: text/html; charset=UTF-8'); 
   
  			// Declare encoding META tag, it causes browser to load the UTF-8 charset before displaying the page. 
  			echo '<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />'; 
   
  			// Right to Left issue 
  			echo '<body dir="rtl">'; 
		?>
		<title>. . . تطبيق عسر القراءة . . .</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="Dyslexia" />
		<meta name="author" content="KHALDOUN Mohsen">
		<meta name="keywords" content="Detection,Dyslexia,University,Badji,Mokhtar,Annaba,Algeria,Arabic" />
		<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
		<script src="js/jquery.min.js"></script>
		<script src="js/config.js"></script>
		<script src="js/skel.min.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel-noscript.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-desktop.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><link rel="stylesheet" href="css/ie8.css" /><![endif]-->
		<!--[if lte IE 7]><link rel="stylesheet" href="css/ie7.css" /><![endif]-->
	</head>
	
	<body>

		<!-- Nav -->
			<nav id="nav" align="center">
				<ul class="container">
					<a href="index.php">الخروج</a>
				<li><a href="#copy">اتصل بنا</a></li>
				<li><a href="#results">النتيجة</a></li>
				<li><a href="#test">الاختبار</a></li>
					
					
				</ul>
			</nav>

		<!-- Home -->
			<div class="wrapper wrapper-style1 wrapper-first">
			<article id="test">

				
				<?php	
					session_start();
					
					echo '<h3>مرحبا بك: '.$_SESSION['email'].'</h3>';
				
					//connexion a la bdd 
					include('connex_bdd.php');
					$idq=4;
					$question = $con->query("SELECT * FROM tests");
					




					echo '<form name="quizform" method="post" action="quiz.php">';
					while($row=$question->fetch()) 
					{

						echo"<br>".$row['question']; 
						$model[]=$row['reponse'];

					}
					echo '<h2><input name="next" type="submit" value="اعرف النتيجة"></h2></form>';
					

				?>
				

				</article>
			</div>

<!-- results -->
			<div class="wrapper wrapper-style4">
				<article id="results">





					<header>
						<h2> النتيجة </h2>
					<?php include('trait.php');	?>
					</header>
						
						
				</article>
			</div>

		<!-- Contact -->
			<div class="wrapper wrapper-style4">
				<article id="contact">
					
								<h2>اتصل بنا</h2>
							
				<div class="contact_info">
					<p><img src="images/GoogleMaps.png" alt="GoogleMaps" />
				  <!--<iframe src="https://www.google.com/maps/embed?pb=!1m27!1m12!1m3!1d3194.198840050028!2d7.71813629999998!3d36.81375488272398!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m12!1i0!3e6!4m3!3m2!1d36.813852499999996!2d7.7179169!4m5!1s0x12f0093fa851fb69%3A0xfb67944ccdc78751!2sUniversit%C3%A9+Badji+Mokhtar+Annaba%2C+Alg%C3%A9rie!3m2!1d36.812534!2d7.715872999999999!5e0!3m2!1sfr!2s!4v1398543450419" width="100%"  frameborder="0" style="border:0"></iframe>
			    	 --></p>
				</div>			
								
							
						
				
					
<!-- start foorter -->

	<div class="footer">
		
								
									
		  
		
									
		
								
								
		
			<div class="footer_grid">
				<div class="foot_img"> 
					<img src="images/call.png" alt="" />
				</div>
				<div class="foot_text">
					<p>+213 (0) 38 87 24 36</p>
				</div>		
					<a href="">noreply@univ-annaba.dz
			</a>
			</div>

			
			
		
        
        
 
		


 
		
	</div>
<hr>
        <!-- start footer copy -->
	<div class="copy">	
		<article id="copy">			
				
			<p class="w3-link">2014  جميع الحقوق محفوظة © خلدون محسن   </p>	
			<div class="CONTACTS">
			  <a href="http://www.linkedin.com/profile/view?id=193162917"  ><img src="images/lens17430451_1294953222linkedin-icon.jpg" width="48" height="48" alt="LinkedIN"> 
			  </a>
		    <a href="https://github.com/mohsenuss91" > <img src="images/Logos-Github-icon.png" width="48" height="48" alt="githib"></a>
			</div>
	

 

		</article>
	</div>


	</body>
</html>
