package chapter8;

interface Instrument {
    int i = 5;
    void play(Note n);

    String what();

    void adjust();
}

interface Note{}

class Wind implements Instrument {

    @Override
    public void play(Note n) {
        System.out.print("Wind.play()" + n);
    }

    @Override
    public String what() {
        return "Wind";
    }

    @Override
    public void adjust() {

    }
}
