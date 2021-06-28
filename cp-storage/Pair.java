class Pair implements Comparable<Pair>{
    public int a, b;

    public Pair(){
        this.a = 0;
        this.b = 0;
    }

    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int compareTo(Pair p){
        if(this.a == p.a) return this.b - p.b;  
        return this.a - p.a; 
    }

    @Override
    public String toString(){
        return "<" + this.a + ", " + this.b + ">";
    }
} 
