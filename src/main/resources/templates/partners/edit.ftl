<#import "layout.ftl" as partners_layout/>
<@partners_layout.layout>



<form id="partnerForm" class="form-horizontal" method="post">
    <div class="form-group">
        <label class="col-xs-3 control-label">Название компании</label>
        <div class="col-xs-4">
            <input type="text" class="form-control" name="companyName" value="${companyName!""}"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Дата регистрации</label>
        <div class="col-xs-5 date">
            <div class="input-group input-append date" id="datePicker">
                <input type="text" class="form-control" name="date" about="" value="${registrationDate!""}"/>
                <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-9 col-xs-offset-3">
            <button class="btn btn-primary">Создать</button>
        </div>
    </div>
</form>

<script>
    $(document).ready(function () {
        $('#datePicker')
                .datepicker({
                    format: 'yyyy-mm-dd'
                })
                .on('changeDate', function (e) {
                    // Revalidate the date field
                    $('#partnerForm').formValidation('revalidateField', 'date');
                });


        var options = {
            success:       showSuccess,  // post-submit callback
            clearForm: true        // clear all form fields after successful submit
        };

        function showSuccess(responseText, statusText, xhr, $form) {
            window.location = "/partners";
        }

        $('#partnerForm').ajaxForm(options);

        $('#partnerForm').formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                companyName: {
                    validators: {
                        notEmpty: {
                            message: 'The name is required'
                        }
                    }
                },
                date: {
                    validators: {
                        notEmpty: {
                            message: 'The date is required'
                        },
                        date: {
                            format: 'YYYY-MM-DD',
                            message: 'The date is not a valid'
                        }
                    }
                }
            }
        })
    });
</script>

</@partners_layout.layout>


