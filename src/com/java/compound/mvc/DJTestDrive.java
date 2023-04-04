package com.java.compound.mvc;

import com.java.compound.mvc.controller.BeatController;
import com.java.compound.mvc.model.BeatModel;
import com.java.compound.mvc.model.BeatModelInterface;

/**
 * @author ll
 */
public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        BeatController beatController = new BeatController(model);
    }
}
