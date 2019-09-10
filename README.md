# Программа для расчета прибыльности

# Список команд

Управление программой осуществляется посредством ввода команд, подаваемых в поток
стандартного ввода:

- NEWPRODUCT - Создать товар
- PURCHASE - Закупить товар
- DEMAND - Продать товар
- SALESREPORT - Рассчитать прибыльность

Результат обработки команды - либо **OK**, либо **ERROR**, либо
значение, - выводятся в стандартный поток вывода.
*Команды разделены переносом строки.*

### NEWPRODUCT

Команда создает товар.
На вход подается уникальное
наименование товара

Возможные ответы: 
- OK - товар создан
- ERROR - возможные ошибки: товар уже создан, ошибка ввода параметров

*Пример:* NEWPRODUCT iphone

### PURCHASE 

Команда закупает товар - на вход подается
наименование товара, кол-во закупленного товара, цена единицы товара и дата
закупки

Возможные ответы: 
- OK - товар закуплен  
- ERROR - возможные ошибки: товар не создан, ошибка ввода параметров

*Пример:* PURCHASE iphone 1 1000 01.01.2017
*Для успешного выполнения команды товар для начала должен быть создан через команду  - NEWPRODUCT*


### DEMAND 

Команда продаёт товар - на вход подается
наименование товара, кол-во проданного товара, цена единицы товара и дата
продажи

Возможные ответы: 
- OK - товар продан  
- ERROR - возможные ошибки: товар не создан,товар не закуплен, ошибка ввода параметров

*Пример:* DEMAND iphone 2 5000 01.03.2017
*Для успешного выполнения команды товар для начала должен быть закуплен через команду  - PURCHASE*

### SALESREPORT 

Команда для расчёта прибыли - на вход подается
наименование товара и дата. Результат - прибыль на указанную дату - выводится
в стандартный поток вывода

Возможные ответы: 
- Числовое значение - прибыль на указанную дату   
- ERROR - возможные ошибки: товар не создан, ошибка ввода параметров

*Пример:* SALESREPORT iphone 02.03.2017


