public class square {
    int dim;

    public square(int d) {
        dim = d;
    }

    public void print() {
        System.out.println("sides: " + dim * dim);

    }

}
   class test {
        static void printer (square o){
            o.print();
        }

        public static void main(String[] args) {
            square sq = new square(5);
            printer(sq);
        }
    }

