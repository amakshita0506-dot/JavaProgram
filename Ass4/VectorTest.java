public class VectorTest {

    public static void main(String[] args) {

        try {

            // Valid vectors
            double[] a = {2,3};
            double[] b = {4,5};

            Vector v1 = new Vector(a);
            Vector v2 = new Vector(b);

            Vector sum = v1.add(v2);
            System.out.println("Addition:");
            sum.display();

            double dot = v1.dotProduct(v2);
            System.out.println("Dot Product: " + dot);

            // Dimension mismatch example
            double[] c = {1,2,3};
            Vector v3 = new Vector(c);

            v1.add(v3);   // Will throw exception

        }

        catch(VectorException e){
            System.out.println("Exception: " + e.getMessage());
        }

        // Invalid dimension example
        try {

            double[] d = {1,2,3,4}; // 4D vector not allowed
            Vector v4 = new Vector(d);

        }

        catch(VectorException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}