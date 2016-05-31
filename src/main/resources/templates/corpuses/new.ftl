<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<p class="h3">Добавление нового корпуса</p>

<form id="nameForm" class="form-horizontal">
    <div class="form-group">
        <label for="corpusName">Название:</label>
        <input type="text" class="form-control" id="corpusName" name="corpusName">
    </div>
    <div class="form-group">
        <button id="buttonSubmit" class="btn btn-default">Подтвердить</button>
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

    $("#nameForm").ajaxForm(options);
</script>
