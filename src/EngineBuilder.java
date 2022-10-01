import java.util.Scanner;

/**
 * Класс для быстрого создания двигателей пользователем
 */
public final class EngineBuilder {
    private final Scanner scanner;
    private final EngineType type;
    public EngineBuilder() {
        this.scanner = new Scanner(System.in);
        this.type = this.selectType();
    }
    private EngineType selectType() {
        while (true) {
            System.out.println("Выберите тип двигателя для создания:");
            System.out.println("1. Неопределенный двигатель");
            System.out.println("2. Двигатель внутреннего сгорания");
            System.out.println("3. Дизельный двигатель");
            System.out.println("4. Реактивный двигатель");
            int newVal = receiveIntValue("Тип двигателя", 1, 4);
            switch (newVal) {
                case 1: return EngineType.UNSPECIFIED;
                case 2: return EngineType.INTERNAL_COMBUSTION;
                case 3: return EngineType.DIESEL;
                case 4: return EngineType.JET;
                default: System.out.println("Неверное значение");
            }
        }


    }
    public Engine build() {
        return switch (this.type) {
            case INTERNAL_COMBUSTION -> buildInternalCombustionEngine();
            case DIESEL -> buildDieselEngine();
            case JET -> buildJetEngine();
            default -> buildUnspecifiedEngine();
        };
    }
    private String receiveStringValue(String name) {
        while (true) {
            System.out.printf("Введите параметр двигателя: '%s' (Строка)\n", name);
            String newVal = scanner.nextLine();
            if (newVal.isEmpty()) {
                System.out.println("Пустая строка.");
                continue;
            }
            return newVal;
        }
    }
    private int receiveIntValue(String name, int min, int max) {
        while (true) {
            System.out.printf("Введите параметр двигателя: '%s' (Целое число, минимум %d, максимум %d)\n", name, min, max);
            String newVal = scanner.nextLine();
            if(newVal.isEmpty()) continue;
            try {
                int value = Integer.parseInt(newVal);
                if(value < min || value > max) continue;
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Неверное значение.");
            }
        }
    }
    private double receiveDoubleValue(String name, double min, double max) {
        while (true) {
            System.out.printf("Введите параметр двигателя: '%s' (Число с плавающей точкой, минимум %f, максимум %f)\n", name, min, max);
            String newVal = scanner.nextLine();
            if(newVal.isEmpty()) continue;
            try {
                double value = Double.parseDouble(newVal);
                if(value < min || value > max) continue;
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Неверное значение.");
            }
        }
    }
    private Engine buildUnspecifiedEngine() {
        return new Engine(receiveStringValue("Название"), receiveDoubleValue("КПД", 0, 1));
    }
    private InternalCombustionEngine buildInternalCombustionEngine() {
        return new InternalCombustionEngine(receiveStringValue("Название"), receiveDoubleValue("КПД", 0, 1),
                receiveIntValue("Количество цилиндров", 1, 16), receiveDoubleValue("Объем в литрах", 0.2, 16),
                receiveStringValue("Рекомендованное топливо (октановое число)"));
    }
    private DieselEngine buildDieselEngine() {
        return new DieselEngine(receiveStringValue("Название"), receiveDoubleValue("КПД", 0, 1),
                receiveIntValue("Количество цилиндров", 1, 16), receiveDoubleValue("Объем в литрах", 0.2, 16),
                receiveStringValue("Модель насоса высокого давления"), receiveIntValue("Количество тактов", 2, 4));
    }
    private JetEngine buildJetEngine() {
        return new JetEngine(receiveStringValue("Название"), receiveDoubleValue("КПД", 0, 1),
                receiveDoubleValue("Диаметр в метрах", 0.1, 60), receiveStringValue("Тип потребляемого топлива"));
    }
}
