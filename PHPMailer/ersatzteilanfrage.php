<?php
$auftragsnummer = $_POST['auftragsnummer'];
$firmenname = $_POST['firmenname'];
$ansprechpartner = $_POST['ansprechpartner'];
$referenznummer= $_POST['referenznummer'];
$email = $_POST['email'];
$phone = $_POST['telefon'];
$art1name = $_POST['art1name'];
$art1num = $_POST['art1num'];
$art1anz = $_POST['art1anz'];
$art2name = $_POST['art2name'];
$art2num = $_POST['art2num'];
$art2anz = $_POST['art2anz'];
$art3name = $_POST['art3name'];
$art3num = $_POST['art3num'];
$art3anz = $_POST['art3anz'];
$message = $_POST['message'];
$formcontent=" Auftragsnummer: $auftragsnummer \n\n Firmenname: $firmenname  \n\n Ansprechpartner: $ansprechpartner \n\n Referenznummer: $referenznummer \n\n E-Mail: $email \n\n Telefon: $phone \n\n
Artikel1-Name: $art1name \n\n Artikel1-Nummer: $art1num \n\n Artikel1-Anzahl: $art1anz \n\n Artikel2-Name: $art2name \n\n Artikel2-Nummer:  $art2num \n\n Artikel2-Anzahl: $art2anz \n\n Artikel3-Name: $art3name \n\n Artikel3-Nummer: $art3num \n\n Artikel3-Anzahl: $art3anz \n\n Anmerkungen: $message";
$recipient = "jmmediamail@gmail.com";
$subject = "Ersatzteilanfrage";
$mailheader = "Ersatzteilanfrage Homepageformular";//"From: $email \r\n";
mail($recipient, $subject, $formcontent, $headers) or die("Error!");
header( 'Location: ./thankyou.html' );
?>
