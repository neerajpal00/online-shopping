<div class="container">
	<div class="row">

		<!-- would be display sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>


		<!-- would be display actual products -->
		<div class="col-md-9">

			<!-- added breadcrumb component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/onlineshopping/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					 <c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/onlineshopping/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if> 

				</div>

			</div>

		</div>
		<!-- col-md-9 -->
	</div>
	<!-- row div -->
</div>
<!-- container div -->