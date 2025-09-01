public class MyClass {
    // Nested class MyClass
    public static class MyClassNew {
        private int privateVar;

        public MyClassNew(int initialValue) {
            this.privateVar = initialValue;
        }

        // Getter method to retrieve the value of privateVar
        public int getPrivateVar() {
            return privateVar;
        }

        // Setter method to modify the value of privateVar
        public void setPrivateVar(int newValue) {
            this.privateVar = newValue;
        }
    }

    public static void main(String[] args) {
        MyClassNew obj = new MyClassNew(10);

        // Accessing the private variable using a getter method
        int value = obj.getPrivateVar();
        System.out.println("PrivateVar from outside the class: " + value);

        // Attempting to change the private variable directly (this will result in a compilation error)
        // obj.privateVar = 20;

        // Modifying the private variable using the setter method
        obj.setPrivateVar(20);
        System.out.println("PrivateVar after modification: " + obj.getPrivateVar());
    }
}
