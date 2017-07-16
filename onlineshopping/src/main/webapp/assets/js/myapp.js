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
		
	case 'All Products':
		$('#listProducts').addClass('active');
		
		default:
			if(menu=='Home') break;
			$('#listProducts').addClass('active');
		    $('#a_'+menu).addClass('active');
		    		break;


	}




//CODE FOR JQUERY DATATABLE
//CREATE A DATASET

var products=[
              	['11','ABC'],
              	['12','BC'],
              	['13','C'],
              	['14','DABC'],
              	['15','EABC'],
              	['116','FABC'],
              	['17','GABC'],
              	['18','HABC'],
              	['19','IABC'],
              	['20','JABC']
              	
               ];

var $table=$('#productListTable');

if($table.length)
	{
	
	$table.DataTable({
		
		lengthMenu:[ [3,5,10,-1],['3 records', '5 records','10 records','All']  ],
		pageLength:5,
		data:products
	});
	//console.log('inside the table');
	}
});