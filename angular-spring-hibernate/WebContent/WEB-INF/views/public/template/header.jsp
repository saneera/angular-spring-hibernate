<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div id="header">
  <div class="div1">
    <div class="div2"><img src="../img/logo.png" title="Administration"></div>
        <div class="div3"><img src="../img/lock.png" alt="" style="position: relative; top: 0px;">&nbsp;You are logged in as <span>${user.firstName}</span></div>
      </div>
    <div id="menu">
    <ul class="left sf-js-enabled" style="display: block;" ng-controller="LocationController">
      
      <li id="dashboard" ng-class="{'selected': activeURL == 'home', '': activeURL != 'home'}">
      	<a href="<c:url value="/"/>" title='<spring:message code="header.home"/>' class="top">
			<spring:message code="header.home" />
		</a>
     </li>
     
     <li id="users" ng-class="{'selected': activeURL == 'users', '': activeURL != 'users'}">
      	<a href="<c:url value='/protected/users'/>" title='<spring:message code="header.users"/>' class="top">
			<spring:message code="header.users" />
		</a>		
     </li>
     
     <li id="contact" ng-class="{'selected': activeURL == 'contacts', '': activeURL != 'contacts'}">
      	<a href="<c:url value='/protected/contacts'/>" title='<spring:message code="header.contacts"/>' class="top">
			<spring:message code="header.contacts" />
		</a>
	 </li> 
   
    </ul>
    <ul class="right sf-js-enabled" style="display: block;">
        <li><a class="top" href="<c:url value='/logout' />"><spring:message code="header.logout"/></a></li>
    </ul>
  </div>
  </div>
