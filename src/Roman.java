import java.util.*;
import java.util.stream.Collectors;

enum Roman {
    I(1), IV(4), V(5), IX(9), X(10), XIV(14), XIX(19), XXIV(24), XXIX(29),
    XXXIV(34), XXXIX(39), XLIV(44), XLIX(49), L(50), LIV(54), LIX(59), LXIV(64),
    LXIX(69), LXXIV(74), LXXIX(79), LXXXIV(84), LXXXIX(89), XCIV(94), XCIX(99), C(100);

    private int val;

    Roman(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
    public static List<Roman> reversVal() {
        List<Roman> reverse = new ArrayList<>(List.of(Roman.values()));
        Collections.reverse(reverse);
        return reverse;
//      return Arrays.stream(values()).sorted(Comparator.comparing((Roman e) -> e.val).reversed()).collect(Collectors.toList());
    }
}
