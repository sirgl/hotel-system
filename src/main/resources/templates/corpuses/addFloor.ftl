<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<p class="h3">Добавление нового этажа</p>

<form id="addFloorForm" class="form-horizontal" >
    <div class="form-group">
        <label for="number">Номер этажа</label>
        <input type="number" class="form-control" id="number" name="number">
    </div>
    <#--<div class="form-group">-->
        <#--<button id="buttonSubmit" class="btn btn-default">Подтвердить</button>-->
    <#--</div>-->

</form>

</@application_layout.layout>

<script>
    var options = {
        type: "post",
        success: showSuccess,  // post-submit callback
        clearForm: true        // clear all form fields after successful submit
    };

    function showSuccess(responseText, statusText, xhr, $form) {
        var id = parseInt(responseText);
        window.location = "/floors/" + id;
    }

    $("#addFloorForm").ajaxForm(options);
</script>
