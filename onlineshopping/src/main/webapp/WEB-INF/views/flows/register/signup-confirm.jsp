
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@include file="../shared/flows-header.jsp"%>
<div class="container">

	<div class="row">

		<!-- column to dispaly personal Delatil -->
		<div class="col-md-6">

			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Personal-Details</h4>

				</div>

				<div class="panel-body">
				<!-- display here user detail -->
				
					<div class="text-center">
					   <h4>${myRegModel.user.firstName}  ${myRegModel.user.lastName }</h4>
					   <h5>Email: ${myRegModel.user.email}</h5>
					   <h5>Contact No: ${myRegModel.user.contactNumber}</h5>
					   <h5>Role: ${myRegModel.user.role}</h5>
					
					</div>
				</div>


				<div class="panel-footer">
					<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">edit</a>
				
				</div>


			</div>
		</div>

		<!-- column to dispaly personal Delatil -->

		<div class="col-md-6">
			<div class="panel panel-primary">

				<div class="panel-heading">

					<h4>Billing-Address</h4>

				</div>

				<div class="panel-body">
					<div class="text-center">
						<!-- Display billing address detail -->
						<h5>Address Line:${myRegModel.billing.addressLineOne}</h5>
						<h5>Address Line2: ${myRegModel.billing.addressLineTwo}</h5>
						<h5>${myRegModel.billing.city} - ${myRegModel.billing.postalCode}</h5>
						<h5>${myRegModel.billing.state}  ${myRegModel.billing.country}</h5>
						
					</div>     
				</div>

				<div class="panel-footer">
				   <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">edit</a>
				
				</div>


			</div>
		</div>
	</div>
	
	
	
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="text-center">
			 <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">confirm</a>
			
			</div>
		</div>
	</div>

</div>





<%@include file="../shared/flows-footer.jsp"%>
