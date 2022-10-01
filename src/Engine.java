import java.util.Objects;

/**
 * Базовый класс двигателя. Содержит поля name (Название), efficiency (КПД)
 */
public class Engine {
    protected final String name;
    protected final Double efficiency;

    public Engine() {
        this.name = "Неизвестно";
        this.efficiency = 0.0;
    }

    public Engine(String name, Double efficiency) {
        this.name = name;
        this.efficiency = efficiency;
    }

    /**
     * @return КПД в формате процентов "100%"
     */
    public String getEfficiencyString() {
        return String.format("%.2g%%", efficiency * 100);
    }
    @Override
    public String toString() {
        return String.format("Двигатель %s с КПД: %s", name, this.getEfficiencyString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return name.equals(engine.name) && efficiency.equals(engine.efficiency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, efficiency);
    }
}
