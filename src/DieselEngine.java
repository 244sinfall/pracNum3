import java.util.Objects;
/**
 * Дизельный двигательнаследуется от {@link InternalCombustionEngine}
 * Имеет дополнительные поля: highPressurePump(модель насосов высокого давления), bars(количество тактов)
 */
public class DieselEngine extends InternalCombustionEngine {
    protected String highPressurePump;
    protected int bars;

    public DieselEngine() {
        super();
        this.highPressurePump = "Неизвестно";
        this.bars = 2;
    }
    public DieselEngine(String name, double efficiency, int cylindersCount, double volume, String highPressurePump, int bars) {
        super(name, efficiency, cylindersCount, volume, "ДТ");
        this.highPressurePump = highPressurePump;
        this.bars = bars;
    }

    @Override
    public String toString() {
        return String.format("""
                        Дизельный двигатель %s с КПД: %s
                        Рекомендованное топливо: %s, объем: %.1g л, количество цилиндров: %s
                        Модель насосов высокого давления: %s, количество тактов: %d""",
                this.name, this.getEfficiencyString(), this.recommendedFuel,
                this.volume, this.cylindersCount, this.highPressurePump, this.bars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DieselEngine that = (DieselEngine) o;
        return bars == that.bars && highPressurePump.equals(that.highPressurePump);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), highPressurePump, bars);
    }
}
