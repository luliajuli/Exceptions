public class Main {
    // Исключение для ошибки размера массива
    static class MyArraySizeException extends Exception {
        public String message;
        public MyArraySizeException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    // Исключение для ошибки данных в массиве
    static class MyArrayDataException extends Exception {
        public String message;
        public MyArrayDataException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }

    // Метод для проверки массива и вычисления суммы
    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Array must be 4x4 in size.");
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data at cell [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] incorrectSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] incorrectDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "seven", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArrayElements(correctArray);
            System.out.println("Sum of elements: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Processed correctArray.");
        }

        try {
            int result = sumArrayElements(incorrectSizeArray);
            System.out.println("Sum of elements: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Processed incorrectSizeArray.");
        }

        try {
            int result = sumArrayElements(incorrectDataArray);
            System.out.println("Sum of elements: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Processed incorrectDataArray.");
        }
    }
}
