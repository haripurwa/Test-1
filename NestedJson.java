import java.util.List;
import java.util.Map;

public class NestedJson {
    public static boolean isValid(Object obj) {
        if (obj == null) return true;
        if (obj instanceof String
                || obj instanceof Number
                || obj instanceof Boolean) return true;
        if (obj instanceof Map<?, ?> m) {
            for (var e : m.entrySet()) {
                if (!(e.getKey() instanceof String)) return false;
                if (!isValid(e.getValue())) return false;
            }
            return true;
        }
        if (obj instanceof List<?> l) {
            for (var item : l) if (!isValid(item)) return false;
            return true;
        }
        if (obj.getClass().isArray()) {
            for (Object item : (Object[]) obj)
                if (!isValid(item)) return false;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var ok = Map.of("user", Map.of("name", "Andi", "age", 22),
                "skills", List.of("java", "spring"));
        var notOk = Map.of(999, "wrong key");
        var mixed = new Object[]{"hello", 42, Map.of("check", true)};
        System.out.println(isValid(ok));
        System.out.println(isValid(notOk));
        System.out.println(isValid(mixed));
    }

}
