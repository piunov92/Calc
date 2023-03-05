/*import java.util.*;*/

enum Roman {

    /*I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100);*/

    M(1000), CM(900), D(500), CD(400), C(100), XC(90),
    L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

    private final int val;

    Roman(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
    /*public static List<Roman> reversVal() {
        List<Roman> reverse = new ArrayList<>(List.of(Roman.values()));
        Collections.reverse(reverse);
        return reverse;
//      return Arrays.stream(values()).sorted(Comparator.comparing((Roman e) -> e.val).reversed()).collect(Collectors.toList());
    }*/
}
