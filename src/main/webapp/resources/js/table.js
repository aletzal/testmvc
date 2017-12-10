var prefix = '/sys/';

var GetTickets = function () {
    $.ajax({
        type: 'GET',
        url: prefix + 'showTickets',
        data: 'json',
        contentType: 'application/json',
        success: function (data) {
            // Number of records
            var count = 0;
            $('#main_table tbody').html('<tr></tr>');
            $.each(data, function (i, value) {
                addRow(data[i].id,data[i].film,data[i].name,data[i].email,data[i].hall,data[i].row,data[i].place,data[i].status);
                count++;
            })
            if (count != 0) $('#status_receive').html('<h3>Найдено билетов: ' + count + '</h3>');
            else $('#status_receive').html('<h3>Билетов не найдено.</h3>');
        }
    })
}

function addRow(data_id,data_film,data_name,data_email,data_hall,data_row,data_place,data_status){
    img_edit = '<a href="/sys/edit?pid='+data_id+'"><img src="/resources/img/edit.png"/></a>';
    img_delete = '<a href="/sys/delete?pid='+data_id+'"><img src="/resources/img/delete.png"/></a>';
    $('#main_table tr:last').after(
        '<tr><td>'+data_id+'</td><td>'+data_film+'</td><td>'+data_name+'</td><td>'+data_email+'</td><td>'+data_hall+'</td><td>'+data_row+'</td><td>'+data_place+'</td><td>'+data_status+'</td>'+'<td>' + img_edit + '</td><td>' + img_delete + '</td></tr>');
}