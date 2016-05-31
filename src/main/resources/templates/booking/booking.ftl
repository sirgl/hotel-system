<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<p class="h3">Бронирование</p>

<form id="rangeForm" class="form-horizontal">
    <div class="form-group">
        <label>Период:</label>
        <input class="form-control" type="text" name="daterange" value="01/01/2015 - 01/31/2015" />
    </div>

    <div class="form-group">
        <label for="sel1">Отель</label>
        <select class="form-control" id="sel1" name="corpusId">
            <#list corpuses as corpus>
                <option value="${corpus.id}">${corpus.name}</option>
            </#list>
        </select>
    </div>

    <div>
        <button class="btn btn-primary">Ок</button>
    </div>
</form>

<hr>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Номер</th>
        <th>Этаж</th>
        <th>Число мест</th>
        <th></th>
    </tr>
    </thead>
<tbody>
    <#list rooms! as room>
    <tr>
        <td>${room.number!""}</td>
        <td>${room.floor.number!""}</td>
        <td>${room.places?size}</td>
        <td>
            <a href="#" class="btn btn-info" role="button">Бронировать</a>
        </td>
    </tr>
    </tbody>
    </#list>
</table>


</@application_layout.layout>

<script>
    $(function() {
        $('input[name="daterange"]').daterangepicker();
    });
</script>