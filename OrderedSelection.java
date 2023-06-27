public class OrderedSelection {
    /*
    In this program, we set N to 4 and R to 3 to make an ordered selection of 3 items from a set of 4 items.
    We initialize an array `items` with the numbers from 1 to N.

    The `generateSelections()` method uses recursion to generate all possible selections.
    It takes an array `items`, an array `selection` to store the current selection, and an `index` to track the current position in the selection.
    If the index is equal to the length of the selection, it means we have made a complete selection, so we print it.
    Otherwise, for each item in the `items` array, we assign it to the current position in the selection and recursively call `generateSelections()` for the next index.
    */
    public static void main(String[] args) {
        int N = 4; // Number of items/jobs
        int R = 3; // Number of items/jobs to select/inorder
        
        int[] items = new int[N];
        for (int i = 0; i < N; i++) { //Initializing items
            items[i] = i + 1;
        }

        int[] selection = new int[R];
        boolean[] used = new boolean[N]; // Keep track of used items
        generateSelections(items, selection, used, 0);
    }

    public static void generateSelections(int[] items, int[] selection, boolean[] used, int index) {
        if (index == selection.length) {
            printSelection(selection);//selection complete
            return;
        }

        for (int i = 0; i < items.length; i++) {
            if (!used[i]) {
                selection[index] = items[i];
                used[i] = true; // Mark item as used
                generateSelections(items, selection, used, index + 1);
                used[i] = false; // Reset the used flag for backtracking
            }
        }
    }

    public static void printSelection(int[] selection) {
        for (int item : selection) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
