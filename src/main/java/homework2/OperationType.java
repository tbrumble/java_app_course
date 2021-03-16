package homework2;

/**
 * Класс утилита с перечислением поддерживаемых операций и методов конвертации операции из строки в тип и наоборот
 * Содержит метод поиска операции в веденной пользователем строке и метод вычисления финального значения
 */
public enum OperationType {
    //перечисление поддерживаемых операций
    ADDITION,
    SUBTRACTION,
    DIVISION,
    MULTIPLICATION,
    NONE;


    /**
     * Результат вычисления в зависимости от типа операции (+,-,/,*)
     * @param operationType  тип операции
     * @param values  аргументы операции
     * @return Значение вычисления операции в типе String
     */
    public static String getOperationResult(OperationType operationType, double[] values){
        double resultValue = 0;

        switch (operationType){
            case ADDITION:
                resultValue = values[0] + values[1];
                break;
            case SUBTRACTION:
                resultValue = values[0] - values[1];
                break;
            case DIVISION:
                resultValue = values[0] / values[1];
                break;
            case MULTIPLICATION:
                resultValue = values[0] * values[1];
                break;
        }
        return String.valueOf(resultValue);
    }

    /**
     * Перевод enum типа в строку с учётом экранирования символов
     * Используется для разделения веденной пользователем строки на два аргумента
     * @param operationType тип операции
     * @return String тип с учётом экранирования
     */
    public static String getOperationType(OperationType operationType){
        String operation = "";
        switch (operationType){
            case ADDITION:
                operation = "\\".concat(OPERATION_CONSTANTS.ADDITION);
                break;
            case SUBTRACTION:
                operation = OPERATION_CONSTANTS.SUBTRACTION;
                break;
            case DIVISION:
                operation = OPERATION_CONSTANTS.DIVISION;
                break;
            case MULTIPLICATION:
                operation = "\\".concat(OPERATION_CONSTANTS.MULTIPLICATION);
                break;
            case NONE:
                break;
        }
        return operation;
    }

    /**
     * Поиск в веденной пользователем строки поддерживаемой операции
     * @param text веденная пользователем строка в консоли
     * @return OperatinType поддерживамой операции
     */
    public static OperationType searchOperationTypeInText(String text){
        if (text.contains(OPERATION_CONSTANTS.SUBTRACTION)){
            return OperationType.SUBTRACTION;
        } else if (text.contains(OPERATION_CONSTANTS.MULTIPLICATION)){
            return OperationType.MULTIPLICATION;
        } else if (text.contains(OPERATION_CONSTANTS.DIVISION)){
            return OperationType.DIVISION;
        } else if (text.contains(OPERATION_CONSTANTS.ADDITION)){
            return OperationType.ADDITION;
        } else {
            return NONE;
        }
    }

    /**
     * Текствое представление поддерживаемых операций
     */
    public static class OPERATION_CONSTANTS {
        public static final String MULTIPLICATION = "*";
        public static final String ADDITION = "+";
        public static final String SUBTRACTION = "-";
        public static final String DIVISION = "/";
    }
}
