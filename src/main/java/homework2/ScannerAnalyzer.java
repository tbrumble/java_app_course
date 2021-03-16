package homework2;

import lombok.experimental.Accessors;

import java.io.InputStream;
import java.util.Scanner;

@Accessors(chain = true)
public class ScannerAnalyzer {
    /**
     * Метод для конвертации введенной пользователем строки в арифметическую операцию
     * @param inputStream - system.in
     * @return класс операция с распарсенными числами и определением арифметической операции
     * Если произошла ошибка распознования данных или неподдерживаемая операция - содержит сообщение пользователю с ошибкой
     */
    public OperationExt getOperation(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream);
        String userInputData = scanner.nextLine();
        OperationExt operationExt;

        //проверяем на возможные ошибки, если находим возвращаем сообщение пользователю
        operationExt = checkForErrors(userInputData);
        if (operationExt != null){
            return operationExt;
        }

        //определяем тип операции и аргументы
        OperationType operationType = OperationType.searchOperationTypeInText(userInputData);
        double[] values = getSplittedValues(userInputData, OperationType.getOperationType(operationType));

        //если определили аргументы и операции - создаем объект для вычисления
        if (values != null) {
            operationExt = (OperationExt) new OperationExt().
                    setError(Boolean.FALSE).
                    setOperationType(operationType).
                    setValueBeforeOperation(values[0]).
                    setValueAfterOperation(values[1]);

        } else {
            //иначе возвращаем ошибку
            operationExt = new OperationExt().
                    setError(Boolean.TRUE).
                    setErrorMessage("Ошибка определения аргументов и типа операции");
        }

        return operationExt;
    }

    /**
     * Получение аргументов операции
     * @param inputData введенная строка пользователя из консоли
     * @param regex символ операции, по которой будем разбивать строку
     * @return получем массив из двух чисел
     */
    public double[] getSplittedValues(String inputData, String regex){
        String[] values = inputData.split(regex);
        if ((values.length != 2)) {
            return null;
        } else {
            try {
                return new double[]{Double.parseDouble(values[0]), Double.parseDouble(values[1])};
            } catch (NumberFormatException exception){
                return null;
            }
        }
    }

    /**
     * Проверка введенных пользователем данных
     * Проверяем на ошибку пустой строки
     * Проверяем на ошибки несоответствия операции (поддерживается + - / *
     * @param inputUserData ввеенная пользователем строка в консоли
     * @return Операция с указанием, что ошибка распознования и сообщением для пользователя
     */
    public OperationExt checkForErrors(String inputUserData){
        if (inputUserData.isEmpty()){
            return new OperationExt().
                    setError(Boolean.TRUE).
                    setErrorMessage("Ошибка ввода, введите число и операцию");

        } else if (!inputUserData.contains(OperationType.OPERATION_CONSTANTS.ADDITION) &&
            !inputUserData.contains(OperationType.OPERATION_CONSTANTS.DIVISION) &&
            !inputUserData.contains(OperationType.OPERATION_CONSTANTS.MULTIPLICATION) &&
            !inputUserData.contains(OperationType.OPERATION_CONSTANTS.SUBTRACTION)){
            return new OperationExt().
                    setError(Boolean.TRUE).
                    setErrorMessage("Неподдерживаемая операция");
        }
        return null;
    }

}
