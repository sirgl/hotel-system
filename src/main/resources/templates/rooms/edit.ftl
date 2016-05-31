<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<form id="addRoomForm" class="form-horizontal">
    <div class="form-group col-sm-4">
        <label for="number">Номер комнаты</label>
        <input type="number" class="form-control input-sm" id="number" name="number" value="${room.number!0}">
    </div>

    <div class="form-group col-sm-4">
        <label for="price">Цена</label>
        <input type="number" class="form-control input-sm" id="price" name="price" value="${room.cost!0}">
    </div>

    <div class="form-group col-sm-4">
        <label for="places">Количество мест</label>
        <input type="number" class="form-control input-sm" id="places" name="places" value="${room.places?size!0}">
    </div>

    <div class="form-group col-sm-4">
        <button class="btn btn-default" id="addRoom">Сохранить</button>
    </div>
</form>

</@application_layout.layout>

<script>
    var options = {
        type: "post",
        success: showSuccess,  // post-submit callback
        clearForm: true        // clear all form fields after successful submit
    };

    function showSuccess(responseText, statusText, xhr, $form) {
        window.location = "/corpuses";
    }

    $("#addRoomForm").ajaxForm(options);
</script>
