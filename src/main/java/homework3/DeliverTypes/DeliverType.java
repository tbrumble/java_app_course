package homework3.DeliverTypes;

/**
 * Типы доставок и коэффициент для каждого типа
 */
public enum DeliverType {
    Train,
    Airplane,
    Car,
    PostMan,
    Deers;



    public Double getDeliverCostByType(DeliverType deliverType){
        switch (deliverType){
            case Airplane:
                return 2.25;
            case Train:
                return 2.5;
            case Deers:
                return 1.8;
            case PostMan:
                return 1.5;
            case Car:
                return 2.00;
            default:
                return 1.00;
        }
    }

    private static class CONSTANTS_DELIVERY_TYPES {
        public static String CAR = "Car";
        public static String AIRPLANE = "Airplane";
        public static String POST_MAN = "PostMan";
        public static String TRAIN = "Train";
        public static String DEERS = "Deers";
        public static String ERROR_STRING = "error";
    }
}