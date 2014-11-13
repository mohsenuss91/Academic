-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Lun 16 Juin 2014 à 09:05
-- Version du serveur: 5.1.36-community-log
-- Version de PHP: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `dyslexia`
--

-- --------------------------------------------------------

--
-- Structure de la table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `id_member` int(255) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `familyname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `firstname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sexe` varchar(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `age` int(3) NOT NULL,
  `broandsis` int(2) NOT NULL,
  `classbroandsis` int(2) NOT NULL,
  `view` varchar(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hearing` varchar(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `date_insc` date NOT NULL,
  PRIMARY KEY (`id_member`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `members`
--

INSERT INTO `members` (`id_member`, `email`, `password`, `familyname`, `firstname`, `sexe`, `age`, `broandsis`, `classbroandsis`, `view`, `hearing`, `date_insc`) VALUES
(3, 'admin@mail.com', 'adminpass', 'adminFam', 'adminFN', 'm', 23, 3, 3, 'n', 'y', '2014-06-15'),
(4, 'member@mail.com', 'passmem', 'memfn', 'memberfnam', 'f', 22, 2, 1, 'y', 'n', '2014-05-12');

-- --------------------------------------------------------

--
-- Structure de la table `tests`
--

CREATE TABLE IF NOT EXISTS `tests` (
  `id_test` int(255) NOT NULL AUTO_INCREMENT,
  `question` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `reponse` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_test`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `tests`
--

INSERT INTO `tests` (`id_test`, `question`, `reponse`) VALUES
(1, '<p><img src="images/childrens_q1.jpg" width="255" height="198" alt="childrens"></p><p><h3>كم عدد الاطفال في الصورة ؟</h3></p><h3><label><input type="radio" name="quest1" value="1" id="quest1_0">1</label><br><label><input type="radio" name="quest1" value="2" id="quest1_1">2</label><br><label><input type="radio" name="quest1" value="3" id="quest1_2">3</label></h3></p>', '2'),
(2, '<p> <img src="images/bird_q2.jpg" width="255" height="198" alt="bird"> </p> <p> <h3>ما هو الحرف الناقص ؟</h3> <h2>عصـــ...ـــــور</h2> </p> <p> <h3><label><input type="radio" name="quest2" value="ف" id="quest1_0">ف</label><br> <label><input type="radio" name="quest2" value="ط" id="quest1_1">ط</label><br> <label><input type="radio" name="quest2" value="م" id="quest1_2">م</label><br></h3> </p> ', 'ف'),
(3, '<p> <img src="images/maths_q3.jpg" width="255" height="198" alt="maths"> </p> <p> <h3>اكتب الجواب الصحيح</h3> <h2>9+2= ?</h2> </p> <p> <label><input type="text" name="quest3" size="5" id="quest3_0"></label><br> </p> ', '11'),
(4, '<p> <img src="images/kids_q4.jpg" width="255" height="198" alt="kids_q4"> </p> <p> <h3>اختر المكان الصحيح</h3> <h2>توجد الطفلة ذات القبعة الزرقاء</h2> </p> <p> <h3><label><input type="radio" name="quest4" value="left" id="quest4">على اليسار</label><br><label><input type="radio" name="quest4" value="center" id="quest4">في الوسط</label><br><label><input type="radio" name="quest4" value="right" id="quest4">على اليمين</label></h3></p>  ', 'right');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
