$(document).ready(function () {

    // Initialize DataTables
    var table = $('#ticketTable').DataTable({
        "serverSide": true,  // Important: Tells DataTables that server handles pagination
        "processing": true,  // Shows the "Processing..." loader automatically
        "ordering": false,   // Disable internal sorting since you use external dropdowns
        "searching": false,  // Disable internal search box since you use external input
        "lengthChange": false, // Hide "Show 10 entries" dropdown (optional)
        "pageLength": 10,      // Default page size (matches your pageSize variable)

        "ajax": {
            "url": "/api/tickets/getData",
            "type": "POST",

            "data": function (d) {
                return $.extend({}, d, {
                    "page": (d.start / d.length),
                    "size": d.length,

                    "search": $('#searchBox').val(),
                    "status": $('#statusFilter').val(),
                    "priority": $('#priorityFilter').val(),
                    "sortBy": $('#sortBy').val(),
                    "sortOrder": $('#sortDir').val()
                });
            },
            "dataSrc": function (json) {
                json.recordsTotal = json.totalRecords;
                json.recordsFiltered = json.totalRecords;
                return json.data;
            }
        },

        "columns": [
            { "data": "ticketId" },
            { "data": "title" },
            {
                "data": "status",
                "render": function(data) {
                    return `<span class="badge bg-info">${data}</span>`;
                }
            },
            {
                "data": "priority",
                "render": function(data) {
                    return `<span class="badge bg-warning text-dark">${data}</span>`;
                }
            },
            { "data": "createdOn" }
        ],

        "language": {
            "emptyTable": "No tickets found"
        }
    });

    $('#applyBtn').on('click', function() {
        table.ajax.reload();
    });
});