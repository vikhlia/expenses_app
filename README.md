# expenses_app
Для установки приложения потребуется установить на компьютер JDK-17 и maven

Гайд по настройке maven и необходимых переменных окружения для OS Windows: https://www.youtube.com/watch?v=HaCyw2PlQAQ&ab_channel=KovalevskyiAcademy

После успешной настройки переменных окружения, нужно перейти в папку expenses_app и открыть из нее консоль Git-Bash

В консоли выполнить последовательно команды:

Для компиляции приложения: mvn compile

Для запуска приложения: mvn exec:java -Dexec.mainClass="com.example.vikhlia.ExpensesAppApplication"

После успешного запуска, приложение должно работать по адресу: http://localhost:8080/