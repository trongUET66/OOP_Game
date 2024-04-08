package com.uet.oop;

import com.uet.oop.view.OopGameApplication;
import com.uet.oop.view.commandline.CmdApplication;
import com.uet.oop.view.ui.UiApplication;

public class MainCmd {

    public static void main(String[] args) {
        OopGameApplication application = new CmdApplication();
        application.runApplication();
    }

}
