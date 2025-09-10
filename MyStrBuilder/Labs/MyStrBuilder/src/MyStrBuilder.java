// A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/28/24
//Class - Comp Sci 2K
//Lab  - MyStrBuilder

public class MyStrBuilder {

    // Array in which data is saved
    private char[] data;

    // Number of variables in the array itself
    private int size;


    // Basic constructor
    // No parameters passed in
    // Sets size to 0 and array length to 16
    public MyStrBuilder() {
        size = 0;
        data = new char[16];
    }

    // Constructor
    // Takes in one parameter: capacity or length of the char array
    // Sets char array length to parameter passed in and sets size to 0
    public MyStrBuilder(int capacity) {
        data = new char[capacity];
        size = 0;
    }

    // Constructor
    // Takes in one parameter: character array
    // Puts character array passed in into data, adds 16 more to the length of the array
    //Sets size to the length of the array passed
    public MyStrBuilder(char[] chars) {
        data = new char[chars.length + 16];
        System.arraycopy(chars, 0, data, 0, chars.length);
        size = chars.length;
    }

    // Appends a single character to the data array
    // If buffer is full, creates a new buffer that is 2 more than twice the capacity
    // Adds one to size
    public void append(char c) {
        if (data.length <= size) {
            char[] newData = new char[data.length * 2 + 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = c;
    }

    // Appends an integer to the data array
    // If buffer is full, creates a new buffer that is 2 more than twice the capacity
    // Adds to size the number of digits in the integer
    // Adds one to size if the integer is negative
    public void append(int n) {
        if (n < 0) {
            n = Math.abs(n);
            append('-');
        }
        int numCopy = n;
        int numOfDigit = 0;
        do {
            numOfDigit++;
            numCopy /= 10;

        } while (numCopy != 0);
        for (int i = numOfDigit; i > 0; i--) {
            int digit = (int) (n / (Math.pow(10, i - 1)));
            append((char) (digit + '0'));
            n %= (int) Math.pow(10, i - 1);
        }
    }

    // Appends a array fo characters to the data array
    // If buffer is full, creates a new buffer that is two more than twice the capacity
    // Adds to size the length of the passed in array
    public void append(char[] chars) {
        for (char ch : chars) append(ch);
    }

    // Takes in one parameter, the index at which the find the value
    // If index is invalid, throws an IndexOutOfBoundsException
    // Returns a char value from the specified index
    public char charAt(int i) {
        if (i > size-1 || i < 0) throw new IndexOutOfBoundsException();
        return data[i];
    }

    // Takes in no parameters
    // Returns length of data
    public int capacity() {
        return data.length;
    }

    // Takes in no parameters
    // Returns size
    public int length() {
        return size;
    }

    // Takes in no parameters
    // Returns data array
    public char[] getData() {
        return data;
    }

    // Takes in two parameters, a start and an end
    // If start and/or end index is invalid, throws an IndexOutOfBoundsException
    // Start is inclusive, end is exclusive
    // Returns a new MyStringBuilder object in which is the substring and plus 16 length
    public MyStrBuilder substring(int begin, int end) {
        if (begin < 0 || end > size || end - begin < 0) {
            throw new IndexOutOfBoundsException();
        }
        char[] ret = new char[end - begin];
        for (int i = begin, j = 0; i < end; i++, j++) ret[j] = data[i];
        return new MyStrBuilder(ret);
    }

    // Takes in one parameter, a beginning index
    // Begin is inclusive, and runs to the last character in the buffer
    // If beginning is invalid, throws an IndexOutOfBoundsException
    // Returns a new MyStringBuilder object in which is the substring specified and plus 16 length
    public MyStrBuilder substring(int begin) {
        if (begin < 0 || begin > size) throw new IndexOutOfBoundsException();
        char[] ret = new char[size - begin+1];
        for (int i = begin, j = 0; i < size; i++, j++) ret[j] = data[i];
        return new MyStrBuilder(ret);
    }

    // Takes in no parameters
    // Returns a new MyStringBuilder object in which all elements of the data array are contains
    // but every uppercase letter is now lowercase
    public MyStrBuilder toLowerCase() {
        MyStrBuilder lowerCaseBuilder = new MyStrBuilder(this.size + 16);
        for (int i = 0; i < this.size; i++) {
            char c = this.data[i];
            if (Character.isUpperCase(c)) {
                lowerCaseBuilder.append(Character.toLowerCase(c));
            } else {
                lowerCaseBuilder.append(c);
            }
        }
        return lowerCaseBuilder;
    }

    // Takes in no parameters
    // Returns a new MyStringBuilder object in which all elements of the data array are contains
    // but every lowercase letter is now uppercase
    public MyStrBuilder toUpperCase() {
        MyStrBuilder UpperCaseBuilder = new MyStrBuilder(this.size + 16);
        for (int i = 0; i < this.size; i++) {
            char c = this.data[i];
            if (Character.isLowerCase(c)) {
                UpperCaseBuilder.append(Character.toUpperCase(c));
            } else {
                UpperCaseBuilder.append(c);
            }
        }
        return UpperCaseBuilder;
    }

    // Overrides equals method from parent class Object
    // Takes in one parameter, an Object
    // First typecasts the parameter to a MyStringBuilder
    // Then checks if all attributes of the objects match each other
    // Capacity is irrelevant
    // Returns true if all attributes match except capacity match, else false
    @Override
    public boolean equals(Object obj) {
        MyStrBuilder other = (MyStrBuilder) obj;
        if (other.size != this.size) return false;
        for (int i = 0; i < size; i++) if (this.data[i] != other.data[i]) return false;
        return true;
    }

    // Takes in one parameter, a char
    // Outputs the index at which the char first occurs
    // Outputs -1 is the character doesn't occur in the array
    public int indexOf(char c) {
        for (int i = 0; i < size; i++) if (data[i] == c) return i;
        return -1;
    }

    // Reverse the original data structure
    public void reverse() {
        char[] ret = new char[capacity()];
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            ret[j] = data[i];
        }
        data = ret;
    }

    // Takes in two parameters, an int offset value at which the character has to be inserted at and a character to be inserted
    // If offset value is invalid, throws a IndexOutOfBoundsException
    // Offsets all values to the right of the offset value by one
    // Inserts the new value at the specified location
    public void insert(int offset, char c) {
        if (offset < 0 || offset > capacity()){
            throw new IndexOutOfBoundsException();
        }
        char[] temp = new char[size - offset];
        for (int i = offset, j = 0; i < size; i++, j++) temp[j] = data[i];
        if (offset + size >= data.length) {
            char[] newData = new char[data.length * 2 + 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[offset] = c;
        for (int i = offset + 1, j = 0; j < temp.length; i++, j++){
            data[i] = temp[j];
        }
        size++;
    }

    // Takes in two parameters, an int offset value and an array of characters
    // If offset value is invalid, throws a IndexOutOfBoundsException
    // If buffer is full, then capacity will be doubled and have 2 added to it
    // Offsets all values to the right by the length of the passed in array
    // Inserts the passed in array at the specified location
    // Size has char array length added to it
    public void insert(int offset, char[] chars) {
        for (char c : chars) {
            insert(offset++, c);
        }
    }

    // Takes in one parameter, an integer index
    // Character at specified index has to be deleted
    public void delete(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    // Takes in two parameters, an integer start and an integer end
    // Deletes all characters from the start to the end
    // Start is inclusive, end is exclusive
    // Throws an IndexOutOfBoundsException if start and/or end is invalid
    public void delete(int start, int end) {
        if (start < 0 || end > size || start > end){
            throw new IndexOutOfBoundsException();
        }
        for (int i = start; i < end; i++) delete(start);
    }

    // Takes in two parameters, an integer start and a character array
    // Throws an IndexOutOfBoundsException if start is invalid
    // Start is inclusive
    // Replaces all chars using the characters in the array
    public void replace(int start, char[] chars) {
        if (start < 0 || start > size) throw new IndexOutOfBoundsException();
        if (start + chars.length > data.length) {
            char[] newData = new char[data.length * 2 + 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        for (int i = start, j = 0; j < chars.length; i++, j++) {
            data[i] = chars[j];
        }

    }


}
