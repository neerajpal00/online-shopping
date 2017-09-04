
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@include file="../shared/flows-header.jsp"%>
<div class="container">

	<div class="row">
		<div class="col-md-offset-3 col-md-6">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Sign up - Address</h4>

				</div>

				<div class="panel-body">
					<!-- Form Element modelAttribute same name what you define in ManagementController-->
					<sf:form class="form-horizontal" modelAttribute="billing111"
						id="billingForm1">

						<div class="form-group">
							<label class="control-label col-md-4">Address Line One:</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineOne"
									placeholder="Enter Address Line One" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Address Line Two:</label>
							<div class="col-md-8">
								<sf:input type="text" path="addressLineTwo"
									placeholder="Enter Address Line Two" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">City:</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" placeholder="Enter City"
									class="form-control" />
							</div>
						</div>


						<div class="form-group">
							<label class="control-label col-md-4">State:</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" placeholder="Enter State"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Country:</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" placeholder="Enter Country"
									class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">postalCode:</label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode"
									placeholder="Enter PostalCode" class="form-control" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<button type="submit" name="_eventId_personal"
									class="btn btn-primary">
									 <span class="glyphicon glyphicon-chevron-left"></span>Previous - Personal
								</button>
								
								
								<button type="submit" name="_eventId_confirm"
									class="btn btn-primary">
									Next confirm<span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="../shared/flows-footer.jsp"%>
