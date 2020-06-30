package com.fox.test;

public class JeuVR implements VR {

    @Override
    public void startGame() {
        setJeuEnCours(true);
        System.out.println("vr开始了");
        setJeuEnCours(false);
        System.out.println("vr结束了");
    }

    public void setJeuEnCours(boolean jeuEnCours) {
        JeuEnCours = jeuEnCours;
    }

    private boolean JeuEnCours;

    private boolean getJeuEnCour(){
        return JeuEnCours;
    }
}
