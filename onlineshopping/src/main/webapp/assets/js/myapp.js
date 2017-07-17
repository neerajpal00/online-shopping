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



var $table=$('#productListTable');
if($table.length) {
	//console.log('inside the table');
	
	var jsonUrl = '';
	if(window.categoryId == '') {
		
		jsonUrl=window.contextRoot + '/json/data/all/products';
	}
	else
		{
		jsonUrl=window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';

		}
	
	
	
	$table.DataTable({
		
		lengthMenu:[ [3,5,10,-1],['3 records', '5 records','10 records','All']  ],
		pageLength:5,
		
		ajax: {
			url:jsonUrl,
			dataSrc: ''
		},
		columns: [
		         {
		        	 data:'name'
		         },
		         {
		        	 data:'brand'
		         },
		         {
		        	 data:'unitPrice'
		         },
		         {
		        	 data:'quantity'
		         }
		      ]
		
	
	
	
	
	});
	
	}
});