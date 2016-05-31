<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4">
            <p id="corpusOldName" class="h3">Корпус ${corpus.name!""}</p>
            <p class="h6" data-toggle="collapse" data-target="#renameCollapse">Переименовать</p>
        </div>
    </div>


    <div class="row">
        <div class="col-sm-4">
            <div id="renameCollapse" class="collapse">
                <form id="renameForm" class="form-horizontal">
                    <div class="form-group">
                        <label for="corpusName">Название:</label>
                        <input type="text" class="form-control" id="corpusName">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <hr>

    <#list corpus.floors as floor>
        <div class="well">
            <p class="h3">Этаж ${floor.number}</p>

            <#list floor.rooms as room>
                <div class="well">
                    <p class="h4">Комната ${room.number}</p>
                    <p>Цена ${room.cost}</p>
                    <p>Мест ${room.places?size}</p>
                </div>
            </#list>

            <a href="/floors/${floor.id}" class="btn btn-info">Редактировать</a>
        </div>
    </#list>


    <a href="/corpuses/${corpus.id}/addFloor" id="addFloor" class="btn btn-primary">Добавить этаж</a>

    <button id="delete" class="btn btn-danger">Удалить корпус</button>

    <script>
        function onSuccessDelete() {
            window.location = "/corpuses"
        }

        $("#delete").click(function () {
            $.ajax({
                type: "delete",
                success: onSuccessDelete
            })
        })
    </script>
<#--<button id="saveAll" class="btn btn-primary">Сохранить изменения</button>-->
</div>



</@application_layout.layout>

