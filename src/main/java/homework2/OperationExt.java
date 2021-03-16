package homework2;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
/**
 * Наследник класса Operation
 * Содержит два новых поля ошибка и сообщение ошибки
 * Переопределн метод toString для вывода операции вычисления
 */
public class OperationExt extends Operation {
    //Флаг о наличии ошибки и необходимости вывести ошибку пользователю
    private boolean isError;
    //Сообщенеи об ошибке для вывода пользователю
    private String errorMessage;


    //служебный метод
    private double[] getValuesArray(){
        return new double[] {getValueBeforeOperation(), getValueAfterOperation()};
    }

    /**
     * Возвращает результат операции.
     * @return значение операции или ошибка для пользователя
     */
    @Override
    public String toString(){
        if (isError){
            return errorMessage;
        } else {
            return OperationType.getOperationResult(getOperationType(), getValuesArray());
        }
    }
}
