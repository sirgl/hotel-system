<#import "../layout/layout.ftl" as application_layout/>
<@application_layout.layout>

<div class="well">
    <p>Имя: ${visitor.name}</p>
    <p>Фамилия: ${visitor.surname}</p>
    <p>Дата регистрации: ${visitor.registrationDate}</p>
</div>

<div class="well">
    <p class="h4">Активность:</p>

    <div class="well">
        <#list visitor.bookings as booking>
            <p>Отель: ${booking.place.room.floor.corpus.name}</p>
            <p>Этаж: ${booking.place.room.floor.number}</p>
            <p>Комната: ${booking.place.room.number}</p>
            <p>Время регистрации: ${booking.bookingTime}</p>
            <p>Время заселения: ${booking.arrivalTime}</p>
            <p>Время отбытия: ${booking.dischargeTime}</p>
            <p>Оплачен: ${booking.payed?c}</p>
            <p>Дополнительные услуги:</p>
            <div class="well">
                <#list booking.additionalPayments as payment>
                <div>
                    <p> Название: ${payment.service.name}</p>
                    <p> Цена: ${payment.cost}</p>
                </div>
                </#list>
            </div>

        </#list>
    </div>

</div>

</@application_layout.layout>
