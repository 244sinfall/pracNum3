import java.util.Objects;
/**
 * Реактивный двигатель наследуется от {@link Engine}
 * Имеет дополнительные поля: diameter(диаметр), fuelType(тип топлива)
 */
public class JetEngine extends Engine {
    private final double diameter;
    private final String fuelType;

    public JetEngine() {
        super();
        this.diameter = 0;
        this.fuelType = "Неизвестно";
    }

    public JetEngine(String name, double efficiency, double diameter, String fuelType) {
        super(name, efficiency);
        this.diameter = diameter;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return String.format("Реактивный двигатель %s с КПД: %s\nТип топлива: %s, диаметр: %f", this.name,
                this.getEfficiencyString(), this.fuelType, this.diameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JetEngine jetEngine = (JetEngine) o;
        return Double.compare(jetEngine.diameter, diameter) == 0 && fuelType.equals(jetEngine.fuelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), diameter, fuelType);
    }
}
