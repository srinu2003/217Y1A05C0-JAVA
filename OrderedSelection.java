public class OrderedSelection {
    public static void main(String[] args) {
        int N = 4; // Number of items
        int R = 2; // Number of items to select
        
        int[] items = new int[N];
        for (int i = 0; i < N; i++) {
            items[i] = i + 1;
        }

        int[] selection = new int[R];
        generateSelections(items, selection, 0);
    }

    public static void generateSelections(int[] items, int[] selection, int index) {
        if (index == selection.length) {
            printSelection(selection);
            return;
        }

        for (int i = 0; i < items.length; i++) {
            selection[index] = items[i];
            generateSelections(items, selection, index + 1);
        }
    }

    public static void printSelection(int[] selection) {
        for (int item : selection) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
