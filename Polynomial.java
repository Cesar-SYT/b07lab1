public class Polynomial {
    public double[] poly;
    public Polynomial(){
        poly= new double [1];
    }
    public Polynomial (double[] newP){
        poly = new double[newP.length];
        //System.out.println(poly.length + " " + newP.length);
        System.arraycopy(newP, 0, poly, 0, newP.length);
    }
    public Polynomial add (Polynomial b){
        int Max_len = Math.max(poly.length, b.poly.length);
        double[] new_P = new double[Max_len];
        for (int i = 0; i < Max_len; i++){
            if (poly.length <= i){
                new_P[i] = 0 + b.poly[i];
            } else if (b.poly.length <= i){
                new_P[i] = poly[i] + 0;
            } else new_P[i] = poly[i] + b.poly[i];
        }
        Polynomial new_add_p = new Polynomial(new_P);
        /* 
        System.out.println("debug!!::::");
        for (int i=0; i < Max_len; i++){
            System.out.println(poly[i] + "  " + b.poly[i]+ "  "+ new_P[i]);
        }
        */
        return new_add_p;
    }
    public double evaluate (double x){
        double sum = 0;
        for (int i = 0; i < poly.length; i++){
            sum += poly[i] * Math.pow (x, i);
        }
        return sum;
    }
    public boolean hasRoot(double x){
        double sum = evaluate(x);
        return sum == 0;
    }
}
