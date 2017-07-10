$(function() {
	//solving the active menu problem
	//menu used in page.jsp
	//case 'About Us' used from pageController.java
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');

	case 'Home':
		$('#home').addClass('active');

	}

});