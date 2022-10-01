import java.util.Objects;

/**
 * Двигатель внутреннего сгорания наследуется от {@link Engine}
 * Имеет дополнительные поля: cylindersCount(количество цилиндров), volume(объем), recommendedFuel(рекомендованное топливо)
 */
public class InternalCombustionEngine extends Engine {
    protected final int cylindersCount;
    protected final double volume;
    protected final String recommendedFuel;
    public InternalCombustionEngine() {
        super();
        this.cylindersCount = 0;
        this.volume = 0;
        this.recommendedFuel = "Неизвестно";
    }

    public InternalCombustionEngine(String name, double efficiency, int cylindersCount, double volume, String recommendedFuel) {
        super(name, efficiency);
        this.cylindersCount = cylindersCount;
        this.volume = volume;
        this.recommendedFuel = recommendedFuel;
    }

    @Override
    public String toString() {
        return String.format("Двигатель внутреннего сгорания %s с КПД: %s\nРекомендованное топливо: %s, объем: %.1g л" +
                ", количество цилиндров: %s", this.name, this.getEfficiencyString(), this.recommendedFuel,
                this.volume, this.cylindersCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternalCombustionEngine that = (InternalCombustionEngine) o;
        return cylindersCount == that.cylindersCount && Double.compare(that.volume, volume) == 0 && recommendedFuel.equals(that.recommendedFuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cylindersCount, volume, recommendedFuel);
    }
}
