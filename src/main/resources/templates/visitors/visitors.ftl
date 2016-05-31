<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<p class="h3">Посетители:</p>

<a href="/visitors/add" class="btn btn-info">Добавить</a>
<hr>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Дата регистрации</th>
        <th></th>
    </tr>
    </thead>
<tbody>
    <tr>
    <#list visitors!"" as visitor>
        <td>${visitor.name}</td>
        <td>${visitor.surname}</td>
        <td>${visitor.registrationDate}</td>
        <td>
            <a href="/visitors/${visitor.id}" class="btn btn-info" role="button">Подробнее</a>
        </td>
    </tr>
    </tbody>
    </#list>
</table>

</@application_layout.layout>