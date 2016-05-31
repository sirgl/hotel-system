<#import "layout.ftl" as partners_layout/>
<@partners_layout.layout>
<p>Данные о компаниях за период:</p>
<form id="rangeForm" class="form-horizontal">
    <div>
        <label>Период:</label>
        <input type="text" name="daterange" value="01/01/2015 - 01/31/2015" />
    </div>
    <div>
        <button class="btn btn-primary">Ок</button>
    </div>
</form>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Название</th>
        <th>Дата регистрации</th>
        <th></th>
    </tr>
    </thead>
<tbody>
    <#list partners![] as partner>
    <tr>
        <td>${partner.name}</td>
        <td>${partner.registrationDate}</td>
        <td>
            <a href="/partners/${partner.id}" class="btn btn-info" role="button">Редактировать</a>
        </td>
    </tr>
    </tbody>
    </#list>
</table>

<script type="text/javascript">
    $(function() {
        $('input[name="daterange"]').daterangepicker();
    });
</script>

</@partners_layout.layout>