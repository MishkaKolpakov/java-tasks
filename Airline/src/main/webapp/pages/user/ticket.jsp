<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib prefix="ctg" uri="customtags" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent" />
<html>
<head>
<title>Ticket</title>
</head>
<body>
	<c:import url="/pages/static/header.jsp" />
	
	<fmt:message key="service.date" />
	<c:out value="${ticket.flight.departureDateTime}" /><br>
	<fmt:message key="service.direction" />
	<c:out value="${ticket.flight.flightInstance.from}" />
	<c:out value=" - " />
	<c:out value="${ticket.flight.flightInstance.to}" /><br>
	<fmt:message key="service.duration" />
	<c:out value="${ticket.flight.flightInstance.duration}" /><br>
	<fmt:message key="service.amount" />
	<c:out value="${ticket.flight.placesAmount}" /><br>
	<fmt:message key="ticket.price" />
	<ctg:money amountInCents="${ticket.ticketPrice}" language="${locale}" /><br>
	<fmt:message key="ticket.queue.price" />
	<ctg:money amountInCents="${ticket.firstInQueuePrice}" language="${locale}" /><br>
	<fmt:message key="ticket.baggage.price" />
	<ctg:money amountInCents="${ticket.baggagePrice}" language="${locale}" /><br><br>
	<form action="controller" method="post">
		<input type="hidden" name="command" value="ORDER">
		<input type="hidden" name="ticketId" value="${ticket.id}">
		<fmt:message key="ticket.baggage"/>
		<input type="checkbox" name="baggage" value="baggage" /><br>
		<fmt:message key="ticket.first.queue"/>
		<input type="checkbox" name="firstQueue" value="queue" /><br>
		<input type="submit" value="<fmt:message key="order.order"/>">
	</form>
	<a href="${pageContext.request.contextPath}/controller?command=book"><fmt:message key="ticket.back"/></a>
	<c:import url="/pages/static/footer.jsp" />
</body>
</html>