package Juego.Torneo;

class NodoB {
    private String nombre;
    private NodoB hijoIzq;
    private NodoB hijoDer;

    public NodoB(String nombre, NodoB hijoIzq, NodoB hijoDer) {
        this.nombre = nombre;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoB hijoDer) {
        this.hijoDer = hijoDer;
    }
}
