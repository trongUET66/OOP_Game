package com.uet.oop;

import com.uet.oop.view.OopGameApplication;
import com.uet.oop.view.commandline.CmdApplication;
import com.uet.oop.view.ui.UiApplication;

public class Main {

    public static void main(String[] args) {
        OopGameApplication application = new CmdApplication();
//        OopGameApplication application = new UiApplication();
        application.runApplication();
    }

}
