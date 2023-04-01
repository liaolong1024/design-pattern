package com.java.state;

import com.java.state.state.*;

/**
 * @author ll
 */
public class CandyMachineNew {


    // final static int SOLD_OUT = 0;
    State soldOut = new SoldOutState(this);
    // final static int NO_QUARTER = 1;
    State noQuarter;
    // final static int HAS_QUARTER = 2;
    State hasQuarter = new HasQuarterState(this);
    // final static int SOLD = 3;
    State sold;

    State state = soldOut;
    int count = 0;

    public CandyMachineNew(int count) {
        this.count = count;
        soldOut = new SoldOutState(this);
        noQuarter = new NoQuarterState(this);
        hasQuarter = new HasQuarterState(this);
        sold = new SoldState(this);
        if (count > 0) {
            state = noQuarter;
        }
    }


    // public void insertQuarter() {
    //     if (state == HAS_QUARTER) {
    //         System.out.println("you can't insert another quarter");
    //     } else if (state == SOLD_OUT) {
    //         System.out.println("you can't insert a quarter, the machine is sold out");
    //     } else if (state == SOLD) {
    //         System.out.println("Please wait, we're already giving you a gumball");
    //     } else if (state == NO_QUARTER) {
    //         state = HAS_QUARTER;
    //         System.out.println("You inserted a quarter");
    //     }
    // }

    public void insertQuarter() {
        state.insertQuarter();
    }

    // public void ejectQuarter() {
    //     if (state == HAS_QUARTER) {
    //         System.out.println("Quarter return");
    //         state = NO_QUARTER;
    //     } else if (state == NO_QUARTER) {
    //         System.out.println("You haven't inserted a quarter");
    //     } else if (state == SOLD) {
    //         System.out.println("Sorry, you already turned the crank");
    //     } else if (state == SOLD_OUT) {
    //         System.out.println("You can't eject, you haven't inserted a quarter yet");
    //     }
    // }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    // public void turnCrank() {
    //     if (state == SOLD) {
    //         System.out.println("Turning twice doesn't get you another gumball");
    //     } else if (state == NO_QUARTER) {
    //         System.out.println("You turned but there's no quarter");
    //     } else if (state == SOLD_OUT) {
    //         System.out.println("You turned, but there are no gumballs");
    //     } else if (state == HAS_QUARTER) {
    //         System.out.println("You turned...");
    //         state = SOLD;
    //         dispense();
    //     }
    // }
    public void turnCrank() {
        state.turnCrank();
    }

    // public void dispense() {
    //     if (state == SOLD) {
    //         System.out.println("A gumball comes rolling out the slot");
    //         count -= 1;
    //         if (count == 0) {
    //             state = SOLD_OUT;
    //         } else {
    //             state = NO_QUARTER;
    //         }
    //     } else if (state == NO_QUARTER) {
    //         System.out.println("You need to pay first");
    //     } else if (state == SOLD_OUT) {
    //         System.out.println("No gumball dispensed");
    //     } else if (state == HAS_QUARTER) {
    //         System.out.println("No gumball dispensed");
    //     }
    // }

    public void dispense() {
        state.dispense();
    }

    public State getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(State soldOut) {
        this.soldOut = soldOut;
    }

    public State getNoQuarter() {
        return noQuarter;
    }

    public void setNoQuarter(State noQuarter) {
        this.noQuarter = noQuarter;
    }

    public State getHasQuarter() {
        return hasQuarter;
    }

    public void setHasQuarter(State hasQuarter) {
        this.hasQuarter = hasQuarter;
    }

    public State getSold() {
        return sold;
    }

    public void setSold(State sold) {
        this.sold = sold;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
