<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div ng-app="app">
	<div ng-controller="testController">
      <div id="grid1" ui-grid="{ data: myData }" class="grid"></div>
    </div> 
 </div>
<script src="<c:url value="/scripts/pages/test.js" />"></script>