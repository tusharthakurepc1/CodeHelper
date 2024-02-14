package core.concept;

public class SingeltonClassDesignPattern {
    public static void main(String[] args) {

    }
}

class Addhar{
    private static Addhar adhar = new Addhar();

    private Addhar(){}

    public static Addhar getAddhar(){
        return adhar;
    }
}


