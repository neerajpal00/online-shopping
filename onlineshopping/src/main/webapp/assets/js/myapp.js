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



var $table2=$('#productListTable2');
if($table2.length) {
	//console.log('inside the table');
	
	var jsonUrl2 = '';
	if(window.categoryId3 == '') {
		
		jsonUrl2=window.contextRoot + '/json/data/all/products';
	}
	else
		{
		jsonUrl2=window.contextRoot + '/json/data/category/'+ window.categoryId3 +'/products';

		}
	
	
	
	$table2.DataTable({
		
		lengthMenu:[ [3,5,10,-1],['3 records', '5 records','10 records','All']  ],
		pageLength:5,
		
		ajax: {
			url:jsonUrl2,
			dataSrc: ''
		},
		columns: [
		          {
		        	 data:'code',
		        	 mRender:function(data,type,row) {
		        		 return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg">';
		        	 }
		          },
		         {
		        	 data:'name'
		         },
		         {
		        	 data:'brand'
		         },
		         {
		        	 data:'unitPrice',
		             mRender: function(data,type,row) {
		            	 return '&#8377;' + data;
		             }		 
		         },
		         {
		        	 data:'quantity'
		         },
		         {
		        	 data:'id',
		        	 mRender: function(data,type,row) {
		        		 
		        		 var str='';
		        		 str += '<a href="'+window.contextRoot+'/show/'+data+'/product"  class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span> view</a>  &#160;'; 
		        		 str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to cart</a>';
		        		 
		        		 return str;

		        	 }
		         }
		      ]
		
	
	
	
	
	});
	
	}
});