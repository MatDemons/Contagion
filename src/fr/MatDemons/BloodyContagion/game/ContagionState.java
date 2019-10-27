package fr.MatDemons.Contagion.game;

public enum ContagionState {

    ATTEND(true), GAME(false), FIN(false);

    private boolean canJoin;
    private static ContagionState currentState;

    ContagionState(boolean canJoin){
         this.canJoin = canJoin;
    }

    public boolean canJoin(){
        return canJoin;
    }

    public static void setState(ContagionState state){
        ContagionState.currentState = state;
    }

    public static boolean isState(ContagionState state){
        return ContagionState.currentState == state;
    }

    public static ContagionState getState(){
        return currentState;
    }

}
