class Vector {

    private double[] components;
    private int dimension;

    // Constructor
    public Vector(double[] components) throws VectorException {

        if (components.length != 2 && components.length != 3) {
            throw new VectorException("Only 2D or 3D vectors allowed.");
        }

        this.components = components;
        this.dimension = components.length;
    }

    // Check dimensions
    private void checkDimension(Vector v) throws VectorException {
        if (this.dimension != v.dimension) {
            throw new VectorException("Vector dimensions must be same.");
        }
    }

    // Add
    public Vector add(Vector v) throws VectorException {

        checkDimension(v);

        double[] result = new double[dimension];

        for(int i=0;i<dimension;i++){
            result[i] = this.components[i] + v.components[i];
        }

        return new Vector(result);
    }

    // Subtract
    public Vector subtract(Vector v) throws VectorException {

        checkDimension(v);

        double[] result = new double[dimension];

        for(int i=0;i<dimension;i++){
            result[i] = this.components[i] - v.components[i];
        }

        return new Vector(result);
    }

    // Dot product
    public double dotProduct(Vector v) throws VectorException {

        checkDimension(v);

        double result = 0;

        for(int i=0;i<dimension;i++){
            result += this.components[i] * v.components[i];
        }

        return result;
    }

    // Display
    public void display() {

        System.out.print("Vector: (");

        for(int i=0;i<dimension;i++){
            System.out.print(components[i]);

            if(i < dimension-1)
                System.out.print(", ");
        }

        System.out.println(")");
    }
}