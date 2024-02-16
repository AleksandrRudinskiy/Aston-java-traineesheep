public class HandMadeArrayList<T> {
    private int size = 0;
    private Object[] elements;

    public HandMadeArrayList() {
        this.elements = new Object[10];
    }

    public void add(T newElement) {
        if (size == elements.length) {
            grow();
        }
        elements[size] = newElement;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    private void grow() {
        Object[] newArray = new Object[elements.length + elements.length / 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        this.elements = newArray;
    }

    public int size() {
        return size;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elements[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elements[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index,
                    numMoved);
        elements[--size] = null;
    }

    public void add(int index, Object element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Элемента с интексом " + index + " нет.");
        System.arraycopy(elements, index, elements, index + 1,
                size - index);
        elements[index] = element;
        size++;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null;
        size = 0;
    }


}
