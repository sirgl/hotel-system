<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<p class="h3">Этаж ${floor.number}</p>

    <#list floor.rooms as room>
    <div class="well">
        <p class="h4">Комната ${room.number}</p>
        <p>Цена ${room.cost}</p>
        <p>Мест ${room.places?size}</p>
        <a href="/rooms/${room.id}" class="btn btn-info">Редактировать</a>
        <button class="btn btn-danger" id="deleteRoom${room.id}">Удалить</button>
        <script>
            function onSuccess${room.id}() {
                location.reload();
            }

            $("#deleteRoom${room.id}").click(function () {
                $.ajax("/rooms/${room.id}", {
                    url: "/rooms/${room.id}",
                    type: "delete",
                    success: onSuccess${room.id}
                })
            })
        </script>
    </div>
    </#list>

<div class="row well">
    <form id="addRoomForm" class="form-horizontal">
        <div class="form-group col-sm-4">
            <label for="number">Номер комнаты</label>
            <input type="number" class="form-control input-sm" id="number" name="number">
        </div>

        <div class="form-group col-sm-4">
            <label for="price">Цена</label>
            <input type="number" class="form-control input-sm" id="price" name="price">
        </div>

        <div class="form-group col-sm-4">
            <label for="places">Количество мест</label>
            <input type="number" class="form-control input-sm" id="places" name="places">
        </div>

        <div class="form-group col-sm-4">
            <button class="btn btn-default" id="addRoom">Добавить комнату</button>
        </div>
    </form>
</div>

<button id="deleteFloor" class="btn btn-danger">Удалить этаж</button>

<script>
    function onSuccessDelete() {
        window.location = "/corpuses"
    }

    $("#deleteFloor").click(function () {
        $.ajax({
            type: "delete",
            success: onSuccessDelete
        })
    })
</script>


</@application_layout.layout>

<script>
    var options = {
        url: window.location.href + "/add",
        type: "post",
        success: showSuccess,  // post-submit callback
        clearForm: true        // clear all form fields after successful submit
    };

    function showSuccess(responseText, statusText, xhr, $form) {
        location.reload();
    }

    $("#addRoomForm").ajaxForm(options);
//            .formValidation({
//        framework: 'bootstrap',
//        icon: {
//            valid: 'glyphicon glyphicon-ok',
//            invalid: 'glyphicon glyphicon-remove',
//            validating: 'glyphicon glyphicon-refresh'
//        },
//        fields: {
//            number: {
//                validators: {
//                    notEmpty: {
//                        message: 'The name is required'
//                    }
//                }
//            },
//            price: {
//                validators: {
//                    notEmpty: {
//                        message: 'The date is required'
//                    }
//                }
//            },
//            places: {
//                validators: {
//                    notEmpty: {
//                        message: 'The date is required'
//                    }
//                }
//            }
//        }
//    });
</script>