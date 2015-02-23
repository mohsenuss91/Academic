<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!DOCTYPE HTML>
<!--
	Miniport 2.5 by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>. . . تطبيق عسر القراءة . . .</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="Dyslexia" />
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
					<a href="#top">الدخول</a>
					<li><a href="#copy">اتصل بنا</a></li>
					<li><a href="#Informations">معلومات</a></li>
					<li><a href="#Inscription">التسجيل</a></li>
					
					
				</ul>
			</nav>

		<!-- Home -->
			<div class="wrapper wrapper-style1 wrapper-first">
				<article class="container" id="top">
					<div class="row" align="center">
						<div class="4u">
							<span class="me image image-full">

								<img src="images/3ossr9iraaLogo.JPG" alt="logo" />
							
							</span>

						</div>
						
						<header>
							
							 <h2>  ( : مرحبا بكم في تطبيق  عسر القراءة تفضل</h2> 
									
									<form method="post" action="index.php">
									
										

											<div class="8u" >  
												<input type="email" name="loginemail" id="loginemail" placeholder="بريدك الالكتروني" />
											
											</div>
											
											&nbsp;
											
											<div class="8u">
												<input type="password" name="loginpassword" id="loginpassword" placeholder="كلمت السر" />
											</div>
                                            
                                            &nbsp;
                                           	<div>
												<a href="#" class="button button-alt form-button-reset">مسح</a>
												<a href="#" class="button form-button-submit">دخول</a>
											</div>
											
											<h3>اذا لم يكن لديك حساب في الموقع فالأمر سهل تفضل من هنا</h3>		
											
											<a href="#Inscription" class="button button-big" align="center">تسجيل</a>
									</form>	
									<?php include('login.php');?>								
								
						</header>
							
								
						

						
					</div>
			
				</article>
			</div>

		<!-- Inscription -->
			<div class="wrapper wrapper-style2" >
				<article id="Inscription">
					




						<h2>استمارة التسجيل</h2>
						<span>تفضل بملأ البيانات التالية </span>
					
					<div class="container">
					
						
							<div class="12u">

								<form method="post" action="index.php">
									<div>
										<div class="row half" align="center">


											<div class="12u">
												<p><input type="email" name="email" id="email" placeholder="البريد الالكتروني" /></p>
											</div>
											&nbsp;
											<div class="12u">
												
													<input type="password" name="password" id="password" placeholder="كلمة السر" />
													<input type="password" name="confpassword" id="confpassword" placeholder="تأكيد كلمة السر" />
											
											</div>
											&nbsp;
											<div class="6u">
												<input type="text" name="nom" id="nom" placeholder="اللقب" />
											</div>
											&nbsp;



											<div class="6u">
												<input type="text" name="prenom" id="prenom" placeholder="الاسم" />
											</div>
											&nbsp;
											
											<div class="12u">
												<h3>الجنس</h3>
												<select name="sexe">
													<option name="sexemas" value="m">
														<label for="sexemas">ذكر</label>
													</option>

													<option name ="sexefem" value="f">
														<label for="sexefem">انثى</label>
													</option>

												</select>

											</div>
											&nbsp;


											<div class="12u" >
												<input type="text" name="age" id="age" placeholder="العمر" />
											</div>
											&nbsp;


											<div class="12u" >
												<input type="text" name="brotherandsister" id="brotherandsister" placeholder="عدد الاخوة و الأخوات" />
											</div>
											&nbsp;
											
											<div class="12u" >
												<input type="text" name="classbrotherandsister" id="classbrotherandsister" placeholder="ترتيبك بالنسبة الاخوة و الأخوات" />
											</div>
											&nbsp;

											
											<div class="12u">
												<h3>هل ترى جيدا</h3>
												<select name="vue">
													<option name="vueoui" value="y">
														<label for="vueoui">نعم</label>
													</option>

													<option name ="vuenon" value="n">
														<label for="vueoui">لا</label>
													</option>

												</select>

											</div>
											&nbsp;


											<div class="12u">
												<h3>هل تسمع جيدا</h3>
												<select name="audition">
													<option name="auditionoui" value="y">
														<label for="auditionoui">نعم</label>
													</option>

													<option name ="auditionnon" value="n">
														<label for="auditionnon">لا</label>
													</option>

												</select>
											</div>
											&nbsp;


											<div class="12u">
												<a href="#" class="button button-alt form-button-reset">مسح</a>
												<a href="#" class="button form-button-submit">موافق</a>
										
											</div>
										</div>
										
									
										
										
									</div>
								</form>
							</div>
							
						
					</div>
					<footer>
						<h1>شــــــكرا</h1>
					</footer>
				</article>
				 
			<?php include('singup.php');?>

			</div>

		<!-- Informations -->
			<div class="wrapper wrapper-style3">
				<article id="Informations">





					<header>
						<h2> معلومات </h2>
					

					</header>
			<h3>التطبيق متجاوب و يتأقلم تلقائيا مع اجهزتكم</h3> <img src="images/responsivedyslexiawebsite.PNG" alt="responsivedyslexiawebsite" />		

					
<h3>عُسر القراءة (الدسلكسيا) هو اضطراب تعلمي يتضح بشكل أساسي كصعوبة في القراءة والهجاء وهو منفصل ويختلف عن صعوبات القراءة الناجمة عن أسباب أخرى، مثل مشاكل في الرؤية أو السمع، أو بسبب ضعف مستوى وعدم ملاءمة تعليم القراءة.<br> وهناك تقدير يفيد بأن "عُسر القراءة" يصيب ما بين 5٪ إلى 17٪ من سكان الولايات المتحدة. على الرغم من الاعتقاد بأن عُسر القراءة يكون نتيجة لاختلال عصبي، إلا أنه لا يُعد إعاقة ذهنية. حيث يصيب "عُسر القراءة" أشخاصاً بمستويات ذكاء مختلفة، سواء كان ذكاء متوسط أو فوق المتوسط أو العالي.</h3>
					

<img src="images/dyslexia-and-creativity.JPG" alt="DyslexiaFamous" />
						
							
						
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