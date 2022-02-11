package question.搜索算法;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

public class HasPath {
    public static void main(String[] args) {
        HasPath hasPath = new HasPath();
        boolean res1 = hasPath.hasPath(new char[][]{
                        {'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}},
                "bcced");

        boolean res2 = hasPath.hasPath(new char[][]{
                        {'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}},
                "abcb");
        boolean res3 = hasPath.hasPath(new char[][]{
                        {'a', 'b'}, {'c', 'd'}},
                "abcd");
        boolean res4 = hasPath.hasPath(new char[][]{
                        {'A', 'B', 'C', 'E', 'H', 'J', 'I', 'G'},
                        {'S', 'F', 'C', 'S', 'L', 'O', 'P', 'Q'},
                        {'A', 'D', 'E', 'E', 'M', 'N', 'O', 'E'},
                        {'A', 'D', 'I', 'D', 'E', 'J', 'F', 'M'},
                        {'V', 'C', 'E', 'I', 'F', 'G', 'G', 'S'}},
                "SLHECCEIDEJFGGFIE");
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

    private static class Item {
        public char val;
        public int col;//行
        public int row;//列

        public Item(char val, int col, int row) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return val == item.val && col == item.col && row == item.row;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, col, row);
        }
    }

    private final Set<Item> hasArrive = new HashSet<>();

    public boolean hasPath(char[][] matrix, String word) {
        Stack<Item> stack = new Stack<>();
        char c = word.charAt(0);
        List<Item> startRoots = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (c == matrix[i][j]) {
                    startRoots.add(new Item(matrix[i][j], i, j));
                }
            }
        }
        //无起始元素
        int wordIdx = 0;
        if (startRoots.isEmpty()) return false;
        for (Item startRoot : startRoots) {
            stack.add(startRoot);
            while (!stack.isEmpty()) {
                if (wordIdx == word.length()) return true;
                Item pop = stack.pop();
                if (pop.val == word.charAt(wordIdx)) {
                    wordIdx++;
                    hasArrive.add(pop);
                    List<Item> aroundNode = getAroundNode(pop, matrix);
                    stack.addAll(aroundNode);
                }
            }
            wordIdx = 0;
            stack.clear();
        }
        return false;
    }

    private List<Item> getAroundNode(Item pop, char[][] matrix) {
        ArrayList<Item> items = new ArrayList<>();
        int col = pop.col;
        int row = pop.row;
        if (col + 1 < matrix.length) {
            Item item = new Item(matrix[col + 1][row], col + 1, row);
            if (!hasArrive.contains(item)) items.add(item);
        }
        if (col - 1 >= 0) {
            Item item = new Item(matrix[col - 1][row], col - 1, row);
            if (!hasArrive.contains(item)) items.add(item);
        }
        if (row + 1 < matrix[0].length) {
            Item item = new Item(matrix[col][row + 1], col, row + 1);
            if (!hasArrive.contains(item)) items.add(item);
        }
        if (row - 1 >= 0) {
            Item item = new Item(matrix[col][row - 1], col, row - 1);
            if (!hasArrive.contains(item)) items.add(item);
        }
        return items;
    }


}
