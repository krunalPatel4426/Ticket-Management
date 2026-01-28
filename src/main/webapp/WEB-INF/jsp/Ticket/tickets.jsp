<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ticket Management</title>

    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css" rel="stylesheet">
    <link href="/css/tickets.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container-fluid mt-4">
    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Ticket Dashboard</h4>
        </div>

        <div class="card-body">

            <div class="row g-3 mb-3">
                <div class="col-md-3">
                    <input id="searchBox" class="form-control" placeholder="Search title">
                </div>
                <div class="col-md-2">
                    <select id="statusFilter" class="form-select">
                        <option value="">All Status</option>
                        <c:forEach var="status" items="${statusList}">
                            <option value="${status}">${status}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-2">
                    <select id="priorityFilter" class="form-select">
                        <option value="">All Priority</option>
                        <option value="Urgent">URGENT</option>
                        <option value="High">HIGH</option>
                        <option value="Medium">MEDIUM</option>
                        <option value="LOW">LOW</option>
                    </select>
                </div>
                <div class="col-md-2">
                    <select id="sortBy" class="form-select">
                        <option value="createdOn">Created Date</option>
                        <option value="priority">Priority</option>
                        <option value="status">Status</option>
                    </select>
                </div>
                <div class="col-md-1">
                    <select id="sortDir" class="form-select">
                        <option value="desc">DESC</option>
                        <option value="asc">ASC</option>
                    </select>
                </div>
                <div class="col-md-2">
                    <button id="applyBtn" class="btn btn-primary w-100">Apply</button>
                </div>
            </div>

            <div class="table-responsive">
                <table id="ticketTable" class="table table-hover align-middle" style="width:100%">
                    <thead class="table-light">
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Status</th>
                        <th>Priority</th>
                        <th>Created On</th>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>

        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/dataTables.bootstrap5.min.js"></script>
<script src="/js/tickets.js"></script>
</body>
</html>