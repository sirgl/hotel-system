<#import "layout.ftl" as partners_layout/>
<@partners_layout.layout>
<div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Название</th>
            <th>Дата регистрации</th>
            <th></th>
        </tr>
        </thead>
    <tbody>
        <#list partners as partner>
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
    <a href="/partners/new" class="btn btn-info" role="button">Добавить</a>
</div>
<hr>
<div class="col">
    <a href="/partners/new_companies" class="btn btn-info" role="button">Договоры о сотрудничестве за период</a>
</div>

</@partners_layout.layout>
