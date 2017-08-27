<div class="container">
	<!-- breadcrumb -->
	<!-- ----------------------------------------------------------------------------------------------------- -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">procucts</a>
				<li class="active">${product1.name}</li>

			</ol>

		</div>
	</div>
	<!-- --------------------------------------------------------------------------------------------- -->
	<div class="row">
		<!-- used for responsive so used both("col-xs-12 col-sm-4") show image -->
		<div class="col-xs-12 col-sm-4">
			<img alt="neeraj" src="${images}/${product1.code}.jpg"
				class="img img-responsive" />
			<!-- -here product1 defined in PageController and code is product property  -->
		</div>
		<!-- ----------------------------------------------------------------------------------------------------------- -->
		<!-- used for show description -->
		<div class="col-xs-12 col-sm-8">
			<h3>${product1.name }</h3>
			<hr />
			<p>${product1.description }</p>
			<hr />
			<h4>
				Price: <strong> &#8377; ${product1.unitPrice} /-</strong>
			</h4>
			<hr />


			<c:choose>

				<c:when test="${product1.quantity < 1 }">
					<h6>
						Quantity Available: <span style="color: red"> out of stock</span>
					</h6>

				</c:when>
				<c:otherwise>
					<h6>Quantity Available: ${product1.quantity}</h6>

				</c:otherwise>
			</c:choose>


			<c:choose>

				<c:when test="${product1.quantity < 1 }">
					<a href="javascript:void(0)"
						class="btn btn-success disabled"><strike>
						<span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</strike></a>

				</c:when>
				<c:otherwise>
					<a href="${contextRoot}/cart/add/${product1.id}/product"
						class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>

				</c:otherwise>
			</c:choose>





			<!-- add back button  -->

			<a href="${contextRoot}/show/all/products" class="btn btn-primary">back</a>

		</div>
		<!-- ------------------------------ used for show description -->
	</div>

</div>