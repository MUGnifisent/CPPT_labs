import java.util.ArrayList;

/**
 * Parameterized class <code>Safe</code> implements safe
 */

public class Safe<T extends Object> {
    private ArrayList<T> arr;

    /**
     * Constructor
     */
    public Safe() {
        arr = new ArrayList<T>();
    }

    /**
    * Method find object with the biggest volume
    */
    public T FindMax() {
        if (!arr.isEmpty()) {
            T max = arr.get(0);
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i).compareTo(max) > 0)
                    max = arr.get(i);
            }
            return max;
        }
        return null;
    }

    /**
    * Method add new object to safe
    * @param object value
    */
     public void AddObject(T object) {
        arr.add(object);
        System.out.print("Element added: ");
        object.PrintData();
    }

    /**
    * Method delete object from safe
    * @param i The index of element
    */
    public void DeleteObject(int i) {
        arr.remove(i);
    }
}
