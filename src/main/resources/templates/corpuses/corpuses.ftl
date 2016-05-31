<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<p class="h2">Корпусы</p>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Название</th>
        <th></th>
    </tr>
    </thead>
<tbody>
    <#list corpuses as corpus>
    <tr>
        <td>${corpus.name!"Без названия"}</td>
        <td>
            <a href="/corpuses/${corpus.id}" class="btn btn-info" role="button">Подробно</a>
        </td>
    </tr>
    </tbody>
    </#list>
</table>
<a href="/corpuses/new" class="btn btn-info" role="button">Добавить</a>

</@application_layout.layout>