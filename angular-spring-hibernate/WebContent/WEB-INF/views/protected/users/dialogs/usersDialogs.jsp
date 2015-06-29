<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div id="addUsersModal" class="modal hide fade in centering insertAndUpdateDialogsUser" role="dialog" aria-labelledby="addUsersModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="addUsersModalLabel" class="displayInLine">
			<spring:message code="create" />
			&nbsp;
			<spring:message code="user" />
		</h3>
	</div>
	<div class="modal-body">
		<form name="newUserForm" novalidate>
			<div class="pull-left">
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.username" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required autofocus ng-model="user.userName" name="userName" placeholder="<spring:message code='user'/>&nbsp;<spring:message code='user.username'/>" />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.userName.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.code" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required autofocus ng-model="user.code" name="code" placeholder="<spring:message code='user'/>&nbsp;<spring:message code='user.code'/>" />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.code.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.firstName" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required autofocus ng-model="user.name" name="name" placeholder="<spring:message code='user'/>&nbsp;<spring:message code='user.firstName'/>" />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.name.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.lastName" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required ng-model="user.surname" name="surname" placeholder="<spring:message code='sample.lastname'/> " />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.surname.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.email" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required ng-model="user.email" name="email" placeholder="<spring:message code='sample.email'/> " />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.email.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
								
				
				<input type="submit" class="btn btn-inverse" ng-click="createUser(newUserForm);" value='<spring:message code="create"/>' />
				<button class="btn btn-inverse" data-dismiss="modal" ng-click="exit('#addUsersModal');" aria-hidden="true">
					<spring:message code="cancel" />
				</button>
			</div>
		</form>
	</div>
	<span class="alert alert-error dialogErrorMessage" ng-show="errorOnSubmit"> <spring:message code="request.error" />
	</span>
</div>

<div id="updateUsersModal" class="modal hide fade in centering updateDialogs" role="dialog" aria-labelledby="updateUsersModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="updateUsersModalLabel" class="displayInLine">
			<spring:message code="update" />
			&nbsp;
			<spring:message code="user" />
		</h3>
	</div>
	<div class="modal-body">
		<form name="updateUserForm" novalidate>
			<input type="hidden" required ng-model="user.id" name="id" value="{{user.id}}" />

			<div class="pull-left">
								
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.username" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required autofocus ng-model="user.userName" name="userName" placeholder="<spring:message code='user'/>&nbsp;<spring:message code='user.userName'/>" />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.userName.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.code" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required autofocus ng-model="user.code" name="code" placeholder="<spring:message code='user'/>&nbsp;<spring:message code='user.code'/>" />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.code.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.firstName" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required autofocus ng-model="user.name" name="name" placeholder="<spring:message code='user'/>&nbsp;<spring:message code='user.firstName'/>" />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.name.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.lastName" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required ng-model="user.surname" name="surname" placeholder="<spring:message code='sample.lastname'/> " />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.surname.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				
				<div>
					<div class="input-append">
						<label>* <spring:message code="user.email" />:
						</label>
					</div>
					<div class="input-prepend">
						<input type="text" required ng-model="user.email" name="email" placeholder="<spring:message code='sample.email'/> " />
					</div>
					<div class="input-append">
						<label> <span class="alert alert-error" ng-show="displayValidationError && newUserForm.email.$error.required"> <spring:message code="required" />
						</span>
						</label>
					</div>
				</div>
				
				<input type="submit" class="btn btn-inverse" ng-click="updateUser(updateUserForm);" value='<spring:message code="update"/>' />
				<button class="btn btn-inverse" data-dismiss="modal" ng-click="exit('#updateUsersModal');" aria-hidden="true">
					<spring:message code="cancel" />
				</button>
			</div>
		</form>
	</div>
	<span class="alert alert-error dialogErrorMessage" ng-show="errorOnSubmit"> <spring:message code="request.error" />
	</span>
</div>

<div id="deleteUsersModal" class="modal hide fade in centering" role="dialog" aria-labelledby="searchUsersModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="deleteUsersModalLabel" class="displayInLine">
			<spring:message code="delete" />
			&nbsp;
			<spring:message code="user" />
		</h3>
	</div>
	<div class="modal-body">
		<form name="deleteUserForm" novalidate>
			<p>
				<spring:message code="delete.confirm" />
				:&nbsp;{{user.name}}?
			</p>

			<input type="submit" class="btn btn-inverse" ng-click="deleteUser();" value='<spring:message code="delete"/>' />
			<button class="btn btn-inverse" data-dismiss="modal" ng-click="exit('#deleteUsersModal');" aria-hidden="true">
				<spring:message code="cancel" />
			</button>
		</form>
	</div>
	<span class="alert alert-error dialogErrorMessage" ng-show="errorOnSubmit"> <spring:message code="request.error" />
	</span> <span class="alert alert-error dialogErrorMessage" ng-show="errorIllegalAccess"> <spring:message code="request.illegal.access" />
	</span>
</div>

<div id="searchUsersModal" class="modal hide fade in centering" role="dialog" aria-labelledby="searchUsersModalLabel" aria-hidden="true">
	<div class="modal-header">
		<h3 id="searchUsersModalLabel" class="displayInLine">
			<spring:message code="search" />
		</h3>
	</div>
	<div class="modal-body">
		<form name="searchUserForm" novalidate>
			<label><spring:message code="search.for" /></label>

			<div>
				<div class="input-append">
					<input type="text" autofocus required ng-model="searchFor" name="searchFor" placeholder="<spring:message code='contact'/>&nbsp;<spring:message code='user.name'/> " />
				</div>
				<div class="input-append displayInLine">
					<label class="displayInLine"> <span class="alert alert-error" ng-show="displayValidationError && searchUserForm.searchFor.$error.required"> <spring:message code="required" />
					</span>
					</label>
				</div>
			</div>
			<input type="submit" class="btn btn-inverse" ng-click="searchUser(searchUserForm, false);" value='<spring:message code="search"/>' />
			<button class="btn btn-inverse" data-dismiss="modal" ng-click="exit('#searchUsersModal');" aria-hidden="true">
				<spring:message code="cancel" />
			</button>
		</form>
	</div>
	<span class="alert alert-error dialogErrorMessage" ng-show="errorOnSubmit"> <spring:message code="request.error" />
	</span>
</div>
