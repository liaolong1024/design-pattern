package com.java.compound.mvc.controller;

import com.java.compound.mvc.model.BeatModel;
import com.java.compound.mvc.model.BeatModelInterface;
import com.java.compound.mvc.view.DJView;

import java.lang.reflect.Modifier;

/**
 * @author ll
 */
public class BeatController implements ControllerInterface{

    BeatModelInterface beatModel;
    DJView view;

    public BeatController(BeatModelInterface beatModel) {
        this.beatModel = beatModel;
        view = new DJView(beatModel, this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        beatModel.initialize();
    }

    @Override
    public void start() {
        beatModel.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        beatModel.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void setBPM(int bpm) {
        beatModel.setBPM(bpm);
    }

    @Override
    public void increaseBPM() {
        int bpm = beatModel.getBPM();
        beatModel.setBPM(bpm + 1);
    }

    @Override
    public void decreaseBPM() {
        int bpm = beatModel.getBPM();
        beatModel.setBPM(bpm - 1);
    }
}
