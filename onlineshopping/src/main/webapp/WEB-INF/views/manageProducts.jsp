<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<div class="container">
	<div class="row">
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">$times</button>
					 ${message }
				</div>
			</div>
		
		</c:if>
	
	
	
		<div class="col-md-offset-2 col-md-8">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Product Management "${contextRoot}"</h4>

				</div>

				<div class="panel-body">
				<!-- Form Element modelAttribute same name what you define in ManagementController-->
					<sf:form class="form-horizontal"  modelAttribute="product11" 
					     action="${contextRoot}/manage/products"
					     method="POST"
					     enctype="multipart/form-data"
					
					>

						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter
								Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="brand">Enter
								Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand"
									placeholder="Brand Name" class="form-control" />								
									<sf:errors path="brand" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="description">Product Description:</label>
							<div class="col-md-8">
	                        <sf:textarea path="description" id="description" rows="4" placeholder="Write about Product description"  class="form-control"/>
	                        <sf:errors path="description" cssClass="help-block" element="em" />
	                        
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="unitPrice">Enter
								Unit Price:</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" id="unitPrice"
									placeholder="unit price in &#8377;" class="form-control" />
							</div>
						</div>



						<div class="form-group">
				<label class="control-label col-md-4" for="quantity">Quantity Available:</label>
							<div class="col-md-8">
  <sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control" />
							<sf:errors path="quantity" cssClass="help-block" element="em" />
									
							</div>
						</div>
						
						<!-- File element for image uoload -->
						<div class="form-group">
				<label class="control-label col-md-4" for="file1">Select an Image:</label>
							<div class="col-md-8">
  <sf:input type="file" path="file1" id="file1" class="form-control" />
							<sf:errors path="file1" cssClass="help-block" element="em" />
									
							</div>
						</div>






						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Category:</label>
							<div class="col-md-8">
								<sf:select class="form-control"  path="categoryId" id="categoryId"
								   items="${categories}" 
								   itemLevel="abc" 
								   itemValue="id"
 								
 								/>
 								
 								
									
							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit"
									class="btn btn-primary" />
							</div>
						</div>
<!-- hidden fiels for product -->
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />


					</sf:form>
				</div>

			</div>
		</div>
	</div>
</div>