<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<form id="addVisitorForm" class="form-horizontal">
    <div class="row">
        <div class="form-group col-sm-4">
            <label for="number">Фамилия</label>
            <input type="text" class="form-control input-sm" id="surname" name="surname" value="">
        </div>

        <div class="form-group col-sm-4">

            <label for="price">Имя</label>
            <input type="text" class="form-control input-sm" id="name" name="name" value="">
        </div>
    </div>


    <div class="row">
        <div class="form-group">
            <label class="col-xs-3 control-label">Дата регистрации</label>
            <div class="col-xs-5 date">
                <div class="input-group input-append date" id="datePicker">
                    <input type="text" class="form-control" name="date" about=""/>
                    <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
            </div>
        </div>
    </div>


    <div class="row">
        <div class="form-group col-sm-4">
            <button class="btn btn-default" id="addRoom">Сохранить</button>
        </div>
    </div>
</form>

</@application_layout.layout>

<script>
    $(document).ready(function () {

        var options = {
            type: "post",
            success:       showSuccess,  // post-submit callback
            clearForm: true        // clear all form fields after successful submit
        };

        function showSuccess(responseText, statusText, xhr, $form) {
            window.location = "/visitors";
        }

        $('#addVisitorForm').ajaxForm(options);


        $('#datePicker').datepicker({
            format: 'yyyy-mm-dd'
        })
                .on('changeDate', function (e) {
                    // Revalidate the date field
                    $('#partnerForm').formValidation('revalidateField', 'date');
                });
    });

</script>